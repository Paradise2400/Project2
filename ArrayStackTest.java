import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
        public static void main(String args[]){
            StackInterface<Integer> testStack = new ResizableArrayStack<>();
            testStack.push(testStack.evaluatePostfix("ae+bd-/"));
            System.out.println(testStack.peek());
            testStack.push(testStack.evaluatePostfix("abc*d*-"));
            System.out.println(testStack.peek());
            testStack.push(testStack.evaluatePostfix("abc-/d*"));
            System.out.println(testStack.peek());
            testStack.push(testStack.evaluatePostfix("ebca^*+d-"));
            System.out.println(testStack.peek());
        }
    @org.junit.jupiter.api.Test
    /** Test case #1
     */
    void evaluatePostfix() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(testStack.evaluatePostfix("ae+bd-/"));
        int test = testStack.peek();
        assertEquals(-4, test);
    }
    @org.junit.jupiter.api.Test
    /** Test case #2
     */
    void evaluatePostfix2() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(testStack.evaluatePostfix("abc*d*-"));
        int test = testStack.peek();
        assertEquals(-58, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #3
     */
    void evaluatePostfix3() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(testStack.evaluatePostfix("abc-/d*"));
        int test = testStack.peek();
        assertEquals(-10, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #4
     */
    void evaluatePostfix4() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(testStack.evaluatePostfix("ebca^*+d-"));
        int test = testStack.peek();
        assertEquals(49, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #5 Input with spaces
     */
    void evaluatePostfix5() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(testStack.evaluatePostfix("a e+  b d- / "));
        int test = testStack.peek();
        assertEquals(-4, test);
    }

    @org.junit.jupiter.api.Test
    /** Test case #6 Input with an invalid variable
     */
    void evaluatePostfix6() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        assertThrows(IllegalStateException.class, () -> testStack.evaluatePostfix("zxy+-"));
        }

    @org.junit.jupiter.api.Test
    /** Test case #7 Input with an invalid variable (number)
     */
    void evaluatePostfix7() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        assertThrows(IllegalStateException.class, () -> testStack.evaluatePostfix("12+"));
        }

    @org.junit.jupiter.api.Test
    /** Test case #6 Input with uppercase
     */
    void evaluatePostfix8() {
        StackInterface<Integer> testStack = new ResizableArrayStack<>();
        testStack.push(testStack.evaluatePostfix("AE+bD-/"));
        int test = testStack.peek();
        assertEquals(-4, test);
    }
    }
