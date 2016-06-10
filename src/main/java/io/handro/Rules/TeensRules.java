package io.handro.Rules;

import io.handro.Teens;

import java.util.ArrayList;
/**
 * Created by alejandrolondono on 6/10/16.
 */
public class TeensRules{

    public static String teens(int digit){
        return Teens.values()[digit].getValue();
    }


    public boolean condition(ArrayList<Integer> digits, int iterator) {
        return digits.get(iterator) == 1;
    }

    public int action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator) {
        english.append(teens(correctedDigits.get(iterator)));
        return iterator;
    }
}
