package com.rynkows.superdigit

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by wojciech on 05.06.17.
 */
class SuperdigitTest extends Specification {

    @Unroll
    def 'returns super digits for negative numbers'(){
        given:
            def superdigit = new Superdigit()
        when:
            def superdigitResult = superdigit.calculateSuperDigitForNumber(arg)
        then:
            superdigitResult == result
        where:
            arg         | result
            '-1'        | -1
            '-0'        | 0
            '-1'        | -1
            '-10'       | -1
            '-745'      | 2
            '-07'       | 7
    }

    @Unroll
    def 'returns super digits for positive numbers'(){
        given:
            def superdigit = new Superdigit()
        when:
            def superdigitResult = superdigit.calculateSuperDigitForNumber(arg)
        then:
            superdigitResult == result
        where:
            arg         | result
            '1'         | 1
            '0'         | 0
            '1'         | 1
            '10'        | 1
            '745'       | 7
            '07'        | 7
            '111111111' | 9
    }

    @Unroll
    def 'any other digits are not acceptable than number and minus as first char '(){
        given:
            def superdigit = new Superdigit()
        when:
            superdigit.calculateSuperDigitForNumber(arg)
        then:
            Exception e = thrown(RuntimeException)
            e.getMessage() == Superdigit.SUPER_DIGIT_CONTAINS_INVALID_CHAR
        where:
            arg <<  [ '-1-1', '-0-',  '-10a', '-745+2']
    }


    def 'empty string is not acceptable as superdigit '(){
        given:
            def superdigit = new Superdigit()
        when:
            superdigit.calculateSuperDigitForNumber('')
        then:
            Exception e = thrown(RuntimeException)
            e.getMessage() == Superdigit.EMPTY_SUPER_DIGIT_IS_NOT_A_NUMBER
    }

}
