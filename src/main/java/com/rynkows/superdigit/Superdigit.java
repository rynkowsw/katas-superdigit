package com.rynkows.superdigit;

/**
 * Created by wojciech on 05.06.17.
 */
public class Superdigit {

    private static void validateSuperdigitChar(char nChar){
        if(! Character.isDigit(nChar ) )
            throw new RuntimeException("");

    }




    public static int calculateSuperDigit(String numbers){

        int value=0, index = 0;

        if( numbers.charAt(0) == '-' ) {
            char nChar = numbers.charAt(1);
            validateSuperdigitChar(nChar);
            value = (~(Character.getNumericValue(nChar) -1));
            index=2;
        }

        for ( ; index < numbers.length(); index++) {
            char nChar = numbers.charAt(index);
            validateSuperdigitChar(nChar);
            int number = Character.getNumericValue(nChar);
            value = SuperdigitCalculator.calculateSuperDigitForTooNumbersLowerThanTeen(number,value);
        }

        return value;
    }
}
