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

    TensRules tensRules;
    StringBuilder english;
    ArrayList<Integer> digits;
    @Before
    public void setUp() throws Exception {
        tensRules = new TensRules();
        english = new StringBuilder();
        digits = new ArrayList<>(Arrays.asList(5));
    }

    @Test
    public void conditionTest() throws Exception {
        assertTrue(tensRules.condition(4));
    }

    @Test
    public void actionTest() throws Exception {
        String expected = "Fifty";
        tensRules.action(english, digits, 0);
        assertEquals(expected,english.toString());
    }
    @Test
    public void tensTest(){
        String expected="Fifty";
        String actual = tensRules.tens(5);
        assertEquals(expected,actual);
    }

}
