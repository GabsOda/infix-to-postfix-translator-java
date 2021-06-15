package services;

import entities.ETokenType;
import entities.Token;

public class SimpleLexer {
    
    private Character space[] = {' ', '\n', '\t' }; 

    public int position; 

    public String input; 

    public SimpleLexer(String input) {
        this.input = input; 
        position = 0; 
    }

    private char NextChar() {
        if(position == input.length()){
            return '\0'; 
        }

        return input.charAt(position++); 
    }

    public Token NextToken() {
        char peek; 

        do {
            peek = NextChar(); 
        } while(peek == space[0] || peek == space[1] || peek == space[2]); 

        if(Character.isDigit(peek)){
            String v = "";

            do {
                v += peek; 
                peek = NextChar();
            } while (Character.isDigit(peek)); 

            if(peek != Character.MIN_VALUE){
                position--; 
            }

            return new Token(ETokenType.NUMBER, Integer.parseInt(v));
        }

        switch (peek) {
            case '+':
                return new Token(ETokenType.SUM, null); 
            case '-':
                return new Token(ETokenType.SUB, null); 
            case Character.MIN_VALUE:
                return new Token(ETokenType.EOF, null);
            default:
                return new Token(ETokenType.INVALID, null);
        }
    }
}
