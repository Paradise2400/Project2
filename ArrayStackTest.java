import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
        public static void main(String args[]){
            ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
            testStack.push(ResizableArrayStack.evaluatePostfix("ae+bd-/"));
            System.out.println(testStack.peek());
            testStack.push(ResizableArrayStack.evaluatePostfix("abc*d*-"));
            System.out.println(testStack.peek());
            testStack.push(ResizableArrayStack.evaluatePostfix("abc-/d*"));
            System.out.println(testStack.peek());
            testStack.push(ResizableArrayStack.evaluatePostfix("ebca^*+d-"));
            System.out.println(testStack.peek());
        }
    @org.junit.jupiter.api.Test
    /** Test case #1
     */
    void evaluatePostfix() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(ResizableArrayStack.evaluatePostfix("ae+bd-/"));
        int test = testStack.peek();
        assertEquals(-4, test);
    }
    @org.junit.jupiter.api.Test
    /** Test case #2
     */
    void evaluatePostfix2() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(ResizableArrayStack.evaluatePostfix("abc*d*-"));
        int test = testStack.peek();
        assertEquals(-58, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #3
     */
    void evaluatePostfix3() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(ResizableArrayStack.evaluatePostfix("abc-/d*"));
        int test = testStack.peek();
        assertEquals(-10, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #4
     */
    void evaluatePostfix4() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(ResizableArrayStack.evaluatePostfix("ebca^*+d-"));
        int test = testStack.peek();
        assertEquals(49, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #5 Input with spaces
     */
    void evaluatePostfix5() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(ResizableArrayStack.evaluatePostfix("a e+  b d- / "));
        int test = testStack.peek();
        assertEquals(-4, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #6 Input with an invalid variable
     */
    void evaluatePostfix6() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        assertThrows(IllegalStateException.class, () -> ResizableArrayStack.evaluatePostfix("zxy+-"));
        }

    @org.junit.jupiter.api.Test
    /** Test case #7 Input with an invalid variable (number)
     */
    void evaluatePostfix7() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        assertThrows(IllegalStateException.class, () -> ResizableArrayStack.evaluatePostfix("12+"));
        }

    @org.junit.jupiter.api.Test
    /** Test case #6 Input with uppercase
     */
    void evaluatePostfix8() {
        ResizableArrayStack<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(ResizableArrayStack.evaluatePostfix("AE+bD-/"));
        int test = testStack.peek();
        assertEquals(-4, test);
    }
    }
