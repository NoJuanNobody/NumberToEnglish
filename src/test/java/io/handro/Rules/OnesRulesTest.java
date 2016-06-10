package io.handro.Rules;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class OnesRulesTest {
    OnesRules onesRules;
    @Before
    public void setUp() throws Exception {
        onesRules = new OnesRules();
    }

    @Test
    public void conditionTest() throws Exception {
        assertTrue(onesRules.condition(0));
    }

    @Test
    public void actionTest() throws Exception {
        String expected = "Five";
        String actual = onesRules.action();
        assertEquals(expected,actual);
    }

}