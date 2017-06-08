package com.rynkows.superdigit;

import java.util.stream.IntStream;

/**
 * Created by wojciech on 05.06.17.
 */
public class Superdigit {

    public static String SUPER_DIGIT_CONTAINS_INVALID_CHAR = "Super digit contains invalid char";

    public static String EMPTY_SUPER_DIGIT_IS_NOT_A_NUMBER = "Super digit did not contains numbers";


    private static boolean validateSuperdigitChar(char nChar){
        if(! Character.isDigit( nChar ) )
            throw new RuntimeException(SUPER_DIGIT_CONTAINS_INVALID_CHAR);
        return true;
    }

    private int calculateSuperDigitForPositiveNumber(IntStream numbers) {
        return numbers
                .filter(c -> Superdigit.validateSuperdigitChar((char)c))
                .mapToObj(c -> Character.getNumericValue((char) c))
                .mapToInt(Integer::intValue)
                .reduce(0, SuperdigitCalculator::calculateSuperDigitForTooNumbersLowerThanTeen);
    }

    private int calculateSuperDigitForNegativeNumber(String numbers) {

        char firstNegativeNumberAsChar = numbers.charAt(1);

        validateSuperdigitChar(firstNegativeNumberAsChar);

        int firstNegativeNumber = (~(Character.getNumericValue(firstNegativeNumberAsChar) -1));

        numbers = numbers.substring(2,numbers.length());

        return SuperdigitCalculator.calculateSuperDigitForTooNumbersLowerThanTeen(
                firstNegativeNumber,
                calculateSuperDigitForPositiveNumber(numbers.chars())
        );

    }

    private static boolean isNumberNegative(String number)
    {
        return number.charAt(0) == '-';
    }


    public int calculateSuperDigitForNumber(String numbers){

        if(numbers.length() == 0){
            throw new RuntimeException(EMPTY_SUPER_DIGIT_IS_NOT_A_NUMBER);
        }

        if( isNumberNegative(numbers) ) {
            return calculateSuperDigitForNegativeNumber(numbers);
        }

        return calculateSuperDigitForPositiveNumber( numbers.chars());
    }
}
