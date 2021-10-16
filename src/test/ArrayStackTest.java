package src.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.ResizableArrayStack;
import src.main.PostfixCalc;

class ArrayStackTest {
    @Test
    /** Test case #1
     */
    void evaluatePostfix() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(PostfixCalc.evaluatePostfix("ae+bd-/"));
        int test = testStack.peek();
        assertEquals(-4, test);
    }
    @Test
    /** Test case #2
     */
    void evaluatePostfix2() {
        src.main.ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(PostfixCalc.evaluatePostfix("abc*d*-"));
        int test = testStack.peek();
        assertEquals(-58, test);
    }

    @Test
    /** Test case #3
     */
    void evaluatePostfix3() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(PostfixCalc.evaluatePostfix("abc-/d*"));
        int test = testStack.peek();
        assertEquals(-10, test);
    }

    @Test
    /** Test case #4
     */
    void evaluatePostfix4() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(PostfixCalc.evaluatePostfix("ebca^*+d-"));
        int test = testStack.peek();
        assertEquals(49, test);
    }

    @Test
    /** Test case #5 Input with spaces
     */
    void evaluatePostfix5() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(PostfixCalc.evaluatePostfix("a e+  b d- / "));
        int test = testStack.peek();
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
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(PostfixCalc.evaluatePostfix("AE+bD-/"));
        int test = testStack.peek();
        assertEquals(-4, test);
    }
    }
