package io.handro;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public enum Teens{
    TEN("Ten"), ELEVEN("Eleven"),TWELVE("Twelve"),THIRTEEN("Thirteen"),FOURTEEN("Fourteen"),FIFTEEN("Fifteen"),SIXTEEN("Sixteen"),SEVENTEEN("Seventeen"),EIGHTEEN("Eighteen"),NINETEEN("Nineteen");
    String value;
    Teens(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
