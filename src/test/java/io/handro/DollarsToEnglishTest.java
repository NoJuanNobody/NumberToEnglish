package io.handro;

import io.handro.Rules.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 6/9/16.
 */
public class DollarsToEnglishTest {

    String number, notANumber;
    DollarsToEnglish dollarsToEnglish;

    @Before
    public void setup(){
        number= "2345";
        notANumber="hello";
        dollarsToEnglish = new DollarsToEnglish();
    }

    @Test
    public void isNumberTest(){
        assertTrue(DollarsToEnglish.isNumber(number));
    }

    @Test
    public void isNotNumberTest(){
        assertFalse(DollarsToEnglish.isNumber(notANumber));
    }

    @Test
    public void splitInputTest(){
        String[] expected = {"5","4","3","2"};
        String[] actual = DollarsToEnglish.reverseSplitInput(number);
        assertEquals(Arrays.asList(expected),Arrays.asList(actual));
    }

    @Test
    public void parseStringArrayTest(){
        ArrayList<Integer> expected= new ArrayList<Integer>(Arrays.asList(5,4,3,2));
        String[] strActual = DollarsToEnglish.reverseSplitInput(number);
        ArrayList<Integer>  actual = DollarsToEnglish.parseStringArray(strActual);
        assertEquals(expected.get(3), actual.get(3));
    }

    @Test
    public void onesTest(){
        String expected="Seven";
        String actual = OnesRules.ones(7);
        assertEquals(expected,actual);
    }

    @Test
    public void tensTest(){
        String expected="Fifty";
        String actual = TensRules.tens(5);
        assertEquals(expected,actual);
    }

    @Test
    public void HundredsTest(){
        String expected = "FourHundred";
        String actual = HundredsRules.hundreds(4);
        assertEquals(expected,actual);
    }

    @Test
    public void correctFormatTest(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0,2,1));
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(2,1));
        ArrayList<Integer> actual = DollarsToEnglish.correctFormat(test);
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void toEnglishTest(){
        String expected = "FortySevenThousandTwoHundredNine";
        ArrayList<Integer> number = new ArrayList<>(Arrays.asList(9,0,2,7,4));
        String actual = DollarsToEnglish.toEnglish(number);
        assertEquals(expected,actual);
    }

    @Test
    public void appendDollars(){
        String expected="Dollars";
        String actual = DollarsToEnglish.appendDollars("");
        assertEquals(expected,actual);
    }

    @Test
    public void engineTest(){
        String expected="TwentyThousandDollars";
        String actual = DollarsToEnglish.engine("20000");
        assertEquals(expected,actual);
    }

    @Test
    public void largeNumTest(){
        String expected="NineHundredEighteenMillionThreeHundredFifteenThousandTwoHundredNineteenDollars";
        String actual = DollarsToEnglish.engine("918315219");
        assertEquals(expected,actual);
    }

    @Test
    public void millionTest(){
        String expected="OneMillionDollars";
        String actual = DollarsToEnglish.engine("1000000");
        assertEquals(expected,actual);
    }

    @Test
    public void billionTest(){
        String expected="OneBillionDollars";
        String actual = DollarsToEnglish.engine("1000000000");
        assertEquals(expected,actual);
    }

    @Test
    public void oneThousandTest(){
        String expected="OneThousandDollars";
        String actual = DollarsToEnglish.engine("1000");
        assertEquals(expected,actual);
    }
}
