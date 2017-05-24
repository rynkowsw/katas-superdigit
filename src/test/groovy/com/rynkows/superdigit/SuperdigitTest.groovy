package com.rynkows.superdigit

import spock.lang.Specification

/**
 * Created by wojciech on 25.05.17.
 */
class SuperdigitTest extends Specification {

    def 'calculator for number lower than teen return this number'(){
        given:
            int numberLoverThanTeen = 3
        when:
            int result = Superdigit.calculateSuperDigit(numberLoverThanTeen)
        then:
            result == numberLoverThanTeen
    }

    def 'calculator for number 98741 return valids answer with is 2'(){
        given:
            int definedNumber = 98741
            int expectedResult = 2
        when:
            int result = Superdigit.calculateSuperDigit(definedNumber)
        then:
            result == expectedResult
    }
}
