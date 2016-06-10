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
        String expected="Thousand";
        StringBuilder actual = decimalRules.action(english, digits, 2);
        assertEquals(expected,actual.toString());
    }

    @Test
    public void ZeroTest(){
        String expeted="";
        String actual = decimalRules.decimal(0);
        assertEquals(expeted,actual);
    }

    @Test
    public void ThousandTest(){
        String expeted="Thousand";
        String actual = decimalRules.decimal(3);
        assertEquals(expeted,actual);
    }

    @Test
    public void MillionTest(){
        String expeted="Million";
        String actual = decimalRules.decimal(6);
        assertEquals(expeted,actual);
    }

    @Test
    public void BillionTest(){
        String expeted="Billion";
        String actual = decimalRules.decimal(9);
        assertEquals(expeted,actual);
    }

}