package io.handro.Rules;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class TensRulesSpec {

    TensRules TensRules;
    StringBuilder english;
    ArrayList<Integer> digits;
    @Before
    public void setUp() throws Exception {
        TensRules = new TensRules();
        english = new StringBuilder();
        digits = new ArrayList<>(Arrays.asList(5));
    }

    @Test
    public void conditionTest() throws Exception {
        assertTrue(TensRules.condition(4));
    }

    @Test
    public void actionTest() throws Exception {
        String expected = "Fifty";
        StringBuilder actual = TensRules.action(english, digits, 0);
        assertEquals(expected,actual.toString());
    }

}
