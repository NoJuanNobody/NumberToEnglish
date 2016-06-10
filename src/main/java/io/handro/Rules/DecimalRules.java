package io.handro.Rules;

import io.handro.Decimal;

import java.util.ArrayList;



/**
 * Created by alejandrolondono on 6/10/16.
 */
public class DecimalRules implements Rules {

    public static String decimal(int digit, int position){
        if( digit == 0) return "";
        return Decimal.values()[(position)/2].getValue();
    }

    @Override
    public boolean condition(int input) {
        return false;
    }

    @Override
    public StringBuilder action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator) {
        english.append(decimal(correctedDigits.get(iterator), iterator+1));
        return english;
    }
}
