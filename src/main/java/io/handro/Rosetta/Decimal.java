package io.handro.Rosetta;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public enum Decimal implements Printable{
    ZERO(""),
    THOUSAND("Thousand"),
    MILLION("Million"),
    BILLION("Billion");
    String value;
    Decimal(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
