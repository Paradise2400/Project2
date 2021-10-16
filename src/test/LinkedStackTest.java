package src.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import src.main.LinkedStack;

public class LinkedStackTest {
    @Test
    void isOperator() {
        assertTrue(LinkedStack.isOperator('+'));
        assertFalse(LinkedStack.isOperator('u'));
        assertFalse(LinkedStack.isOperator(']'));
    }

    @Test
    void checkOperatorsAndOperands() {
        String parenthesesChecker = "[a * { b / ( c − d ) + e / ( f + g ) } − h ]";
        assertTrue(LinkedStack.checkOperatorsAndOperands(parenthesesChecker));
    }

    @Test
    void checkBalance() {
        assertTrue(LinkedStack.checkBalance("[a { b / ( c − d ) + e / ( f + g ) } − h ]"));
        assertFalse(LinkedStack.checkBalance("{a ( b * c ) / [d + e] / f )-g}"));
        assertFalse(LinkedStack.checkBalance("{a [ b + ( c + 2 ) / d ] + e ) + f"));
        assertTrue(LinkedStack.checkBalance("a {b [c (d + e)/2 - f] + 1}"));
    }

    @Test
    void convertToPostfix() {
        assertEquals("abc*+",LinkedStack.convertToPostfix("a+b  *c"));
        assertEquals("abc^^",LinkedStack.convertToPostfix("a^b^c"));
        assertEquals("ab/cde-+*",LinkedStack.convertToPostfix("a / b * ( c + ( d - e ) )"));
        assertEquals("ab+cd-/",LinkedStack.convertToPostfix("(a+b)/(c-d)"));
        assertEquals("ab*cd-/",LinkedStack.convertToPostfix("a * b / (c-d)"));
        assertEquals("ab^c*d-e^fgh^^+",LinkedStack.convertToPostfix("(a^b*c-d)^e+f^g^h"));
        assertEquals("abc*-de*f*g+/",LinkedStack.convertToPostfix("(a-b*c)/(d*e*f+g)"));
        assertEquals("ab*ca-/de*+",LinkedStack.convertToPostfix("a*b/(c-a)+d*e"));
        assertThrows(ArithmeticException.class, ()-> LinkedStack.convertToPostfix("{a [ b + ( c + 2 ) / d ] + e ) + f"));

    }
}

