package entities;

public enum ETokenType {

    NUMBER(0),
    SUM(1), 
    SUB(2),
    EOF(99),
    INVALID(-1);

    private int code; 

    private ETokenType(int code){
        this.code = code; 
    }

    public int getCode(){
        return code; 
    }
}
