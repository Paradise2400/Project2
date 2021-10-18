import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
    @Test
    void isOperator() {
        CalcPostfixEval test = new CalcPostfixEval();
        assertTrue(test.isOperator('+'));
        assertFalse(test.isOperator('u'));
        assertFalse(test.isOperator(']'));
    }

    @Test
    void checkOperatorsAndOperands() {
        String parenthesesChecker = "[a { b / ( c − d ) + e / ( f + g ) } − h ]";
        CalcPostfixEval test = new CalcPostfixEval();
        assertTrue(test.checkOperatorsAndOperands(parenthesesChecker));
    }

    @Test
    void checkBalance() {
        CalcPostfixEval test = new CalcPostfixEval();
        assertTrue(test.checkBalance("[a { b / ( c − d ) + e / ( f + g ) } − h ]"));
        assertFalse(test.checkBalance("{a ( b * c ) / [d + e] / f )-g}"));
        assertFalse(test.checkBalance("{a [ b + ( c + 2 ) / d ] + e ) + f"));
        assertTrue(test.checkBalance("a {b [c (d + e)/2 - f] + 1}"));
    }

    @Test
    void convertToPostfix() {
        CalcPostfixEval test = new CalcPostfixEval();
        assertEquals("abc*+",test.convertToPostfix("a+b  *c"));
        assertEquals("abc^^",test.convertToPostfix("a^b^c"));
        assertEquals("ab/cde-+*",test.convertToPostfix("a / b * ( c + ( d - e ) )"));
        assertEquals("ab+cd-/",test.convertToPostfix("(a+b)/(c-d)"));
        assertEquals("ab*cd-/",test.convertToPostfix("a * b / (c-d)"));
        assertEquals("ab^c*d-e^fgh^^+",test.convertToPostfix("(a^b*c-d)^e+f^g^h"));
        assertEquals("abc*-de*f*g+/",test.convertToPostfix("(a-b*c)/(d*e*f+g)"));
        assertEquals("ab*ca-/de*+",test.convertToPostfix("a*b/(c-a)+d*e"));
        assertThrows(ArithmeticException.class, ()-> test.convertToPostfix("{a [ b + ( c + 2 ) / d ] + e ) + f"));

    }
}

