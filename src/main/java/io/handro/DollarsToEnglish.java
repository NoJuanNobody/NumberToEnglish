package io.handro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import io.handro.Rules.*;
/**
 * Created by alejandrolondono on 6/9/16.
 */
public class DollarsToEnglish {

    public static ArrayList<Rules> rules;

    public DollarsToEnglish(){
        rules= new ArrayList<>();
        rules.add(new HundredsRules());
        rules.add(new TensRules());
        rules.add(new OnesRules());
    }

    public static boolean isNumber(String input){
        return input.matches("(\\d)+");
    }

    public static String[] reverseSplitInput(String input){
        return new StringBuffer(input).reverse().toString().split("");
    }

    public static ArrayList<Integer> parseStringArray(String[] strArray){
        ArrayList<Integer> intArray= new ArrayList<>();
        for(String digit : strArray){
            intArray.add(Integer.parseInt(digit));
        }
        return intArray;
    }

    public static ArrayList<Integer> correctFormat(ArrayList<Integer> intArray){
        while(intArray.size()%3 != 0){
            intArray.add(0);
        }
        return intArray;
    }

    public static String toEnglish(ArrayList<Integer> digits){
        StringBuilder english = new StringBuilder();
        ArrayList<Integer> correctedDigits = correctFormat(digits);

        for(int i=correctedDigits.size()-1; i>=0;i--){
            for(Rules rule: rules){
                if(rule.condition(i)){
                    int prevI = i;
                    i = rule.action(english,correctedDigits,i);
                    if(i !=prevI) break;
                }
            }
        }
        return english.toString();
    }

    public static String appendDollars(String text){
        return text+"Dollars";
    }

    public static String engine(String input){
        if(!isNumber(input)){
            System.err.println("Invalid Format");
            return "try again";
        }
        ArrayList<Integer> digits = correctFormat(parseStringArray(reverseSplitInput(input)));
        return appendDollars(toEnglish(digits));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DollarsToEnglish dollarsToEnglish = new DollarsToEnglish();
        String s;
        while ((s = in.readLine()) != null) {
            System.out.println(dollarsToEnglish.engine(s));
        }
    }
}
