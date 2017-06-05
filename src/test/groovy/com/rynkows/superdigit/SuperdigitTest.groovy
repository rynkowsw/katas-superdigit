package com.rynkows.superdigit

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by wojciech on 05.06.17.
 */
class SuperdigitTest extends Specification {

    @Unroll
    def 'returns super digits for negative numbers'(){
        when:
            def superdigit = Superdigit.calculateSuperDigit(arg)
        then:
            superdigit == result
        where:
            arg         | result
            '-1'        | -1
            '-0'        | 0
            '-10'       | -1
            '-745'      | 2
            '-07'       | 7
    }

    @Unroll
    def 'any other digits are not acceptable than number and minus as first char '(){
        when:
            def superdigit = Superdigit.calculateSuperDigit(arg)
        then:
            RuntimeException e = thrown()
        where:
            arg <<  [ '-1-1', '-0-', '', '-10a', '-745+2']
    }

}
