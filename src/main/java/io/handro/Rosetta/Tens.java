package io.handro.Rosetta;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public enum Tens implements Printable {
    ZERO(""), TEN("Ten"), TWENTY("Twenty"), THIRTY("Thirty"), FORTY("Forty"), FIFTY("Fifty"), SIXTY("Sixty"), SEVENTY("Seventy"), EIGHTY("Eighty"), NINETY("Ninety");
    protected String value;
    Tens(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}