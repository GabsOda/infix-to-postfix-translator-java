package services;

import entities.ETokenType;
import entities.Token;
import services.exception.SimpleParserException;

public class SimpleParser {
    
    public String output; 
    private SimpleLexer lexer; 
    private Token lookAhead;

    private StringBuilder sb = new StringBuilder();

    public SimpleParser(SimpleLexer lexer) {
        this.lexer = lexer;     
        this.lookAhead = lexer.NextToken(); 
    }

    private void Match(Token token) {
        if (lookAhead.getType() == token.getType() && lookAhead.getAttribute() == token.getAttribute()){
            lookAhead = lexer.NextToken(); 
        
        } else {
            throw new SimpleParserException("\n *** Syntax Error! Values do not match. *** \n");

        }
    }

    public void Expr() {
        Term(); 
        Rest(); 

        buildOutput();
    }

    public void Rest() {
        if (lookAhead.getType() == ETokenType.SUM) {
            Match(lookAhead); 
            Term(); 
            sb.append("+ "); 
            Rest(); 
        } else if (lookAhead.getType() == ETokenType.SUB) {
            Match(lookAhead);
            Term(); 
            sb.append("- "); 
            Rest(); 
        } else {
            if(lookAhead.getType() != ETokenType.EOF) {
                throw new SimpleParserException("\n *** Sytax Error! Unexpected symbol '" + lookAhead.getAttribute() + "'. ***\n");
            }
        }
    }

    public void Term() {
        if(lookAhead.getType() == ETokenType.NUMBER) {
            sb.append(lookAhead.getAttribute() + " "); 
            Match(lookAhead);
        } else {
            throw new SimpleParserException(" \n *** Syntax Error! '" + lookAhead.getAttribute() + "' it's not a number. *** \n");
        }
    }

    public void buildOutput() {
        output = sb.toString(); 
    }

}
