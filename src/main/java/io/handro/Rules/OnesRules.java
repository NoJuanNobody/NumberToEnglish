package io.handro.Rules;
import io.handro.Rosetta.Ones;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class OnesRules implements Rules {

    DecimalRules decimalrules = new DecimalRules();

    public static String ones(int digit){
        return Ones.values()[digit].getValue();
    }

    @Override
    public boolean condition(int input) {
        return input%3 == 0;
    }

    @Override
    public int action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator) {
        english.append(ones(correctedDigits.get(iterator)));
        if(decimalrules.condition(iterator, correctedDigits)) {
            decimalrules.action(english, correctedDigits, iterator);
        }
        return iterator;
    }
}
