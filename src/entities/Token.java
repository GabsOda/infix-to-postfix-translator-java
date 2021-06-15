package entities;

public class Token {
    
    public ETokenType type; 

    public Integer attribute; 

    public Token(ETokenType type, Integer attribute){
        this.type = type;
        this.attribute = attribute; 
    }

    public ETokenType getType() {
        return type;
    }

    public void setType(ETokenType type) {
        this.type = type;
    }

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

}
