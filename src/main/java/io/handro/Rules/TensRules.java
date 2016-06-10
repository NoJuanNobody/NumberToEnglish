package io.handro.Rules;

import io.handro.Tens;
import java.util.ArrayList;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class TensRules implements Rules {

    public static String tens(int digit){
        if(digit == 0) return "";
        return Tens.values()[digit].getValue();
    }

    @Override
    public boolean condition(int input) {
        return input%3 == 1;
    }

    @Override
    public StringBuilder action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator){
        if(correctedDigits.get(iterator) == 1){
            iterator--;
//            INSERT TEENS
            if(english.toString() !="") {
//                INSERT DECIMAL
            }
//            continue;
        }else {
            english.append(tens(correctedDigits.get(iterator)));
        }
        return english;
    }
}
