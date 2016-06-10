package io.handro.Rules;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class DecimalRulesSpec {


    DecimalRules decimalRules;
    StringBuilder english;
    ArrayList<Integer> digits;

    @Before
    public void setUp() throws Exception {
        decimalRules = new DecimalRules();
        english = new StringBuilder();
        digits = new ArrayList<>(Arrays.asList(0,0,5,0,0));
    }

    @Test
    public void conditionTest() throws Exception {
        assertTrue(decimalRules.condition(2,digits));
    }

    @Test
    public void actionTest() throws Exception {
        String expected="Hundred";
        StringBuilder actual = decimalRules.action(english, digits, 2);
        assertEquals(expected,actual.toString());
    }

}