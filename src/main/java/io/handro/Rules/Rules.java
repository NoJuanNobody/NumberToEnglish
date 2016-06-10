package io.handro.Rules;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public interface Rules {
    boolean condition(int input);
    int action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator);
}
