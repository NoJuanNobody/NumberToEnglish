package io.handro.Rules;

import io.handro.Teens;

import java.util.ArrayList;
/**
 * Created by alejandrolondono on 6/10/16.
 */
public class TeensRules implements Rules {

    public static String teens(int digit){
        return Teens.values()[digit].getValue();
    }

    @Override
    public boolean condition(int input) {
        return false;
    }

    @Override
    public StringBuilder action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator) {
    english.append(teens(correctedDigits.get(iterator)));
        return english;
    }
}
