package io.handro.Rules;

import java.util.ArrayList;
import static io.handro.Rules.DecimalRules.decimal;
import static io.handro.Rules.OnesRules.ones;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class HundredsRules implements Rules {

    public static String hundreds(int digit){
        if(digit == 0) return "";
        return ones(digit)+decimal(digit, 2);
    }

    @Override
    public boolean condition(int input) {
        return input%3==2;
    }

    @Override
    public StringBuilder action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator) {
        english.append(hundreds(correctedDigits.get(iterator)));
        return english;
    }
}
