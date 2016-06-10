package io.handro.Rosetta;

import io.handro.Rosetta.Printable;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public enum Ones implements Printable {
    ZERO(""), ONE("One"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"), SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine");
    String value;
    Ones(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
