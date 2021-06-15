package services;

public class Convertion {
    
   public static String ConvertionInfixToPostfix(String entry) {
       SimpleLexer lexer = new SimpleLexer(entry); 
       SimpleParser parser = new SimpleParser(lexer); 
       parser.Expr();

       return parser.output; 
   }
    
}
