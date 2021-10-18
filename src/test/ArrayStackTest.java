package src.test;

import org.junit.jupiter.api.Test;
import src.main.PostfixCalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A class that tests the Array implementation of the postfix expression.
 */
class ArrayStackTest {
    @Test
    /** Test case #1
     */
    void evaluatePostfix() {
        PostfixCalc testPostfixEval = new PostfixCalc();
        int test = testPostfixEval.evaluatePostfix("ae+bd-/");
        assertEquals(-4, test);
    }
    @Test
    /** Test case #2
     */
    void evaluatePostfix2() {
        PostfixCalc testPostfixEval = new PostfixCalc();
        int test = testPostfixEval.evaluatePostfix("abc*d*-");
        assertEquals(-58, test);
    }

    @Test
    /** Test case #3
     */
    void evaluatePostfix3() {
        PostfixCalc testPostfixEval = new PostfixCalc();
        int test = testPostfixEval.evaluatePostfix("abc-/d*");
        assertEquals(-10, test);
    }

    @Test
    /** Test case #4
     */
    void evaluatePostfix4() {
        PostfixCalc testPostfixEval = new PostfixCalc();
        int test = testPostfixEval.evaluatePostfix("ebca^*+d-");
        assertEquals(49, test);
    }

    @Test
    /** Test case #5 Input with spaces
     */
    void evaluatePostfix5() {
        PostfixCalc testPostfixEval = new PostfixCalc();
        int test = testPostfixEval.evaluatePostfix("a e+  b d- / ");
        assertEquals(-4, test);
    }

    @Test
    /** Test case #6 Input with an invalid variable
     */
    void evaluatePostfix6() {
        assertThrows(IllegalStateException.class, () -> PostfixCalc.evaluatePostfix("zxy+-"));
        }

    @Test
    /** Test case #7 Input with an invalid variable (number)
     */
    void evaluatePostfix7() {
        assertThrows(IllegalStateException.class, () -> PostfixCalc.evaluatePostfix("12+"));
        }

    @Test
    /** Test case #6 Input with uppercase
     */
    void evaluatePostfix8() {
        PostfixCalc testPostfixEval = new PostfixCalc();
        int test = PostfixCalc.evaluatePostfix("AE+bD-/");
        assertEquals(-4, test);
    }
    }
