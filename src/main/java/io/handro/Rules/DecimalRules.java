package io.handro.Rules;

import io.handro.Rosetta.Decimal;

import java.util.ArrayList;



/**
 * Created by alejandrolondono on 6/10/16.
 */
public class DecimalRules {

    public static String decimal(int position){
        return Decimal.values()[(position)/3].getValue();
    }

    public boolean condition(int iterator, ArrayList<Integer> digits) {
        return (digits.get(iterator+1) != 0) || (digits.get(iterator+2)!=0) || (digits.get(iterator)!=0);
    }


    public StringBuilder action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator) {
        english.append(decimal(iterator+1));
        return english;
    }
}
