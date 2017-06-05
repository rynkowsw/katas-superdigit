package com.rynkows.superdigit

import spock.lang.Specification

/**
 * Created by wojciech on 25.05.17.
 */
class SuperdigitCalculatorTest extends Specification {

    def 'throws exception when we provide one of arguments number bigger than 10 or lower than -9 '(){
        given:
            SuperdigitCalculator superdigitCalculator = new SuperdigitCalculator()
        when:
            def superdigit = superdigitCalculator.calculateSuperDigitForTooNumbersLowerThanTeen(firstArg, secondArg)
        then:
            thrown(RuntimeException)
        where:
            firstArg   | secondArg
            -10        | 2
            1          | -20
            11         | 2
            1          | 20
    }

    def 'returns super digits for too numbers'(){
        given:
            SuperdigitCalculator superdigitCalculator = new SuperdigitCalculator()
        when:
            def superdigit = superdigitCalculator.calculateSuperDigitForTooNumbersLowerThanTeen(firstArg, secondArg)
        then:
            superdigit == result
        where:
            firstArg   | secondArg | result
            1          | 2         | 3
            1          | -1        | 0
            9          | -8        | 1
            7          | -8        | -1
            7          | 8         | 6
    }




}
