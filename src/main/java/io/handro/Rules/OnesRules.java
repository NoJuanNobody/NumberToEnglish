package io.handro.Rules;
import io.handro.Ones;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class OnesRules implements Rules {

    public static String ones(int digit){
        return Ones.values()[digit].getValue();
    }

    @Override
    public boolean condition(int input) {
        return input%3 == 0;
    }

    @Override
    public StringBuilder action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator) {
        english.append(ones(correctedDigits.get(iterator)));
//        if((correctedDigits.get(iterator+1) != 0) || (correctedDigits.get(iterator+2)!=0) || (correctedDigits.get(iterator)!=0)) {
//            INSERT DECIMAL
//        }
        return english;
    }
}
