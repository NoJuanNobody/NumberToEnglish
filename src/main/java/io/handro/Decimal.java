package io.handro;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public enum Decimal{
    ZERO(""), HUNDRED("Hundred"), THOUSAND("Thousand"), MILLION("Million"), PLACEHOLDER(""), BILLION("Billion");
    String value;
    Decimal(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
