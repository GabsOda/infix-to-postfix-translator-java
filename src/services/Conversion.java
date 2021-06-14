package services;

import entities.Token;
import entities.enums.TokenType;
import services.exceptions.ConversionException;

public class Conversion {
    
    private String input; 
    private Token lookahead; 
    private int pos = -1; 
    private char peek = ' '; 

    public Conversion(String input) {
        this.input = input; 
    }

    private char nextChar() {
        if (pos == -1) {
            pos = 0; 
        } else if (pos == (int) input.length()) {
            return 0; 
        }

        char next = input.charAt(pos);
        pos++; 

        return next; 
    }

    private Token scan() {
        Token t; 
        for (;;) {
            peek = nextChar();

            if (peek != ' ' && peek != '\t' && peek != '\n') {
                break; 
            }   
        }
        
        if (Character.isDigit(peek)) {
            t = new Token(TokenType.NUMBER, Character.getNumericValue(peek)); 

            return t; 
        } else {
            t = new Token(TokenType.SYMBOL, peek);
            peek = ' ';

            return t; 
        }
    }

    private void match(Token t) {
        if (lookahead.getType().equals(t.getType()) && lookahead.getValue() == t.getValue()) {
            lookahead = scan(); 
        } else {
            throw new ConversionException(" !! Systax Error! Values do not match. !!"); 
        }
    }

    private void term() {
        if (lookahead.getType().equals(TokenType.NUMBER)) {
            System.out.print(lookahead.getValue() + " ");

            match(lookahead); 
        } else {
            throw new ConversionException(" !! Syntax Error! '" + lookahead.getValue() + "' it's not a number, !!"); 
        }
    }

    public void run() {
        lookahead = scan(); 

        term(); 

        while (true) {
            if (lookahead.getType().equals(TokenType.SYMBOL)) {
                if (lookahead.getValue() == '+') {
                    match(lookahead); 

                    term(); 

                    System.out.print("+ ");
                } else if (lookahead.getValue() == '-'){
                    match(lookahead);
                    
                    term();

                    System.out.print("- ");
                } else {
                    return; 
                }
            } else {
                return; 
            }
        }
    }
}
