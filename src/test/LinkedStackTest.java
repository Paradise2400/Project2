package src.test;

import org.junit.jupiter.api.Test;
import src.main.PostfixCalc;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the LinkedImplementations for the obtaining the postfix expressions.
 */
public class LinkedStackTest {
    @Test
    void isOperator() {
        assertTrue(PostfixCalc.isOperator('+'));
        assertFalse(PostfixCalc.isOperator('u'));
        assertFalse(PostfixCalc.isOperator(']'));
    }

    @Test
    void checkOperatorsAndOperands() {
        String parenthesesChecker = "[a * { b / ( c − d ) + e / ( f + g ) } − h ]";
        assertTrue(PostfixCalc.checkOperatorsAndOperands(parenthesesChecker));
    }

    @Test
    void checkBalance() {
        assertTrue(PostfixCalc.checkBalance("[a { b / ( c − d ) + e / ( f + g ) } − h ]"));
        assertFalse(PostfixCalc.checkBalance("{a ( b * c ) / [d + e] / f )-g}"));
        assertFalse(PostfixCalc.checkBalance("{a [ b + ( c + 2 ) / d ] + e ) + f"));
        assertTrue(PostfixCalc.checkBalance("a {b [c (d + e)/2 - f] + 1}"));
    }

    @Test
    void convertToPostfix() {
        assertEquals("abc*+",PostfixCalc.convertToPostfix("a+b  *c"));
        assertEquals("abc^^",PostfixCalc.convertToPostfix("a^b^c"));
        assertEquals("ab/cde-+*",PostfixCalc.convertToPostfix("a / b * ( c + ( d - e ) )"));
        assertEquals("ab+cd-/",PostfixCalc.convertToPostfix("(a+b)/(c-d)"));
        assertEquals("ab*cd-/",PostfixCalc.convertToPostfix("a * b / (c-d)"));
        assertEquals("ab^c*d-e^fgh^^+",PostfixCalc.convertToPostfix("(a^b*c-d)^e+f^g^h"));
        assertEquals("abc*-de*f*g+/",PostfixCalc.convertToPostfix("(a-b*c)/(d*e*f+g)"));
        assertEquals("ab*ca-/de*+",PostfixCalc.convertToPostfix("a*b/(c-a)+d*e"));
        assertThrows(ArithmeticException.class, ()-> PostfixCalc.convertToPostfix("{a [ b + ( c + 2 ) / d ] + e ) + f"));

    }
}

