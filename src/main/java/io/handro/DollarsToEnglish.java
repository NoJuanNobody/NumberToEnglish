package io.handro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alejandrolondono on 6/9/16.
 */
public class DollarsToEnglish {
    public enum Ones{
        ZERO(""), ONE("One"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"), SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine");
        String value;
        Ones(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }
    public enum Tens{
        ZERO(""), TEN("Ten"), TWENTY("Twenty"), THIRTY("Thirty"), FORTY("Forty"), FIFTY("Fifty"), SIXTY("Sixty"), SEVENTY("Seventy"), EIGHTY("Eighty"), NINETY("Ninety");
        protected String value;
        Tens(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }
    public enum Decimal{
        ZERO(""), HUNDRED("Hundred"), THOUSAND("Thousand"), MILLION("Million"), PLACEHOLDER(""), BILLION("Billion");
        String value;
        Decimal(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }
    public enum Teens{
        TEN("Ten"), ELEVEN("Eleven"),TWELVE("Twelve"),THIRTEEN("Thirteen"),FOURTEEN("Fourteen"),FIFTEEN("Fifteen"),SIXTEEN("Sixteen"),SEVENTEEN("Seventeen"),EIGHTEEN("Eighteen"),NINETEEN("Nineteen");
        String value;
        Teens(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
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

    public static String ones(int digit){
        return Ones.values()[digit].getValue();
    }

    public static String teens(int digit){
        return Teens.values()[digit].getValue();
    }

    public static String tens(int digit){
        if(digit == 0) return "";
        return Tens.values()[digit].getValue();
    }
    public static String decimal(int digit, int position){
//        if( digit == 0) return "";
        return Decimal.values()[(position)/2].getValue();
    }
    public static String hundreds(int digit){
        if(digit == 0) return "";
        return ones(digit)+decimal(digit, 2);
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
            if((i)%3 == 2) english.append(hundreds(correctedDigits.get(i)));
            if((i)%3 == 1){
                if(correctedDigits.get(i) == 1){
                    i--;
                    english.append(teens(correctedDigits.get(i)));
                    if(english.toString() !="") {
                        english.append(decimal(correctedDigits.get(i), i+1));
                    }
                    continue;
                }else {
                    english.append(tens(correctedDigits.get(i)));
                }
            }
            if((i)%3 == 0){
                english.append(ones(correctedDigits.get(i)));
                if((correctedDigits.get(i+1) != 0) || (correctedDigits.get(i+2)!=0) || (correctedDigits.get(i)!=0)) {
                    english.append(decimal(correctedDigits.get(i), i+1));
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
        String s;
        while ((s = in.readLine()) != null) {
            System.out.println(DollarsToEnglish.engine(s));
        }
    }

}
