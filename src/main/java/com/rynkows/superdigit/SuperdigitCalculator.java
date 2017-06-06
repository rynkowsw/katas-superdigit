package com.rynkows.superdigit;


/**
 * Created by wojciech on 25.05.17.
 */
public class SuperdigitCalculator {

    public static String SUPER_GIGIT_CONTAINS_INVALID_NUMBER =
            "Given single super digit value can not be lower than -9 and bigger than 10";

    public static int calculateSuperDigitForTooNumbersLowerThanTeen(int value, int value2)
    {
        validateSingleDigit(value);
        validateSingleDigit(value2);


        int sum = value + value2, result;

        if (sum < 10 ) {
            result = sum;
        }
        else {
            result =  ( sum % 10 ) + 1;
        }

        return result;

    }

    private static void validateSingleDigit(int value){
        if( value >= 10 || value < -9 )
            throw new RuntimeException(SUPER_GIGIT_CONTAINS_INVALID_NUMBER);
    }

}
