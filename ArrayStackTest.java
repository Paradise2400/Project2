import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @org.junit.jupiter.api.Test
    /** Test case #1
     */
    void evaluatePostfix() {
        CalcPostfixEval testStack = new CalcPostfixEval();

        int test = testStack.evaluatePostfix("ae+bd-/");
        assertEquals(-4, test);
    }
    @org.junit.jupiter.api.Test
    /** Test case #2
     */
    void evaluatePostfix2() {
        CalcPostfixEval testStack = new CalcPostfixEval();
        int test = testStack.evaluatePostfix("abc*d*-");
        assertEquals(-58, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #3
     */
    void evaluatePostfix3() {
        CalcPostfixEval testStack = new CalcPostfixEval();
        int test = testStack.evaluatePostfix("abc-/d*");
        assertEquals(-10, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #4
     */
    void evaluatePostfix4() {
        CalcPostfixEval testStack = new CalcPostfixEval();
        int test = testStack.evaluatePostfix("ebca^*+d-");
        assertEquals(49, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #5 Input with spaces
     */
    void evaluatePostfix5() {
        CalcPostfixEval testStack = new CalcPostfixEval();
        int test = testStack.evaluatePostfix("a e+  b d- / ");
        assertEquals(-4, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #6 Input with an invalid variable
     */
    void evaluatePostfix6() {
        CalcPostfixEval testStack = new CalcPostfixEval();
        assertThrows(IllegalStateException.class, () -> testStack.evaluatePostfix("zxy+-"));
        }

    @org.junit.jupiter.api.Test
    /** Test case #7 Input with an invalid variable (number)
     */
    void evaluatePostfix7() {
        CalcPostfixEval testStack = new CalcPostfixEval();
        assertThrows(IllegalStateException.class, () -> testStack.evaluatePostfix("12+"));
        }

    @org.junit.jupiter.api.Test
    /** Test case #6 Input with uppercase
     */
    void evaluatePostfix8() {
        CalcPostfixEval testStack = new CalcPostfixEval();
        int test = testStack.evaluatePostfix("AE+bD-/");
        assertEquals(-4, test);
    }
    }
