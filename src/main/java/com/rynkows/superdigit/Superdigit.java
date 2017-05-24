package com.rynkows.superdigit;

public class Superdigit {

    public static int calculateSuperDigit(Integer value)
    {
        if(value < 10 ) {
            return value;
        }

        value = value.toString()
                .chars()
                .mapToObj(c -> Character.getNumericValue((char) c))
                .mapToInt(Integer::intValue)
                .sum();

        return Superdigit.calculateSuperDigit(value);
    }

}
