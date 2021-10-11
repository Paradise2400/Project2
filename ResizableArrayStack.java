import java.util.Arrays;
import java.util.EmptyStackException;

/**
 A class of stacks whose entries are stored in an array.
 @author Frank M. Carrano and Timothy M. Henry
 @version 5.0
 */
public final class ResizableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;    // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ResizableArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    }
    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop
    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty
    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek
    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                    "allowed maximum of " + MAX_CAPACITY);
    }
    public void clear()
    {
        while (!isEmpty()) {
            this.pop();
        }
    } // end clear
    public static int evaluatePostfix(String input) {
        StackInterface<Integer> valueStack = new ResizableArrayStack<>(input.length());
        for(int i = 0; i < input.length(); i++){
            String input2 = input.toLowerCase();
            char variable = input2.charAt(i);
            for(int k = 'f'; k <= 'z'; k++){
                if(k == variable)
                    throw new IllegalStateException("Invalid input");
            }
            for(int j = '1'; j <= '9'; j++){
                if(j == variable)
                    throw new IllegalStateException("Invalid input");
            }
            if (variable == 'a')
                variable = 2;
            if (variable == 'b')
                variable = 3;
            if (variable == 'c')
                variable = 4;
            if (variable == 'd')
                variable = 5;
            if (variable == 'e')
                variable = 6;
            if(variable == ' ')
                continue;
            if(variable != '+' && variable != '-'&& variable != '/' && variable != '*' && variable != '^'){
                valueStack.push((int)variable);
            }
            else{
                if(variable == '+'){
                    int operandTwo = valueStack.pop();
                    int operandOne = valueStack.pop();
                    int result = operandOne + operandTwo;
                    valueStack.push(result);
                }
                if(variable == '-'){
                    int operandTwo = valueStack.pop();
                    int operandOne = valueStack.pop();
                    int result = operandOne - operandTwo;
                    valueStack.push(result);
                }
                if(variable == '*'){
                    int operandTwo = valueStack.pop();
                    int operandOne = valueStack.pop();
                    int result = operandOne * operandTwo;
                    valueStack.push(result);
                }
                if(variable == '/'){
                    int operandTwo = valueStack.pop();
                    int operandOne = valueStack.pop();
                    int result = operandOne / operandTwo;
                    valueStack.push(result);

                }
                if(variable == '^'){
                    int operandTwo = valueStack.pop();
                    int operandOne = valueStack.pop();
                    int result = (int)Math.pow(operandOne,operandTwo);
                    valueStack.push(result);

                }
            }
        }
        return valueStack.peek();
    }

    public static String convertToPostfix(String infix) {
        return LinkedStack.convertToPostfix(infix);
    }

} // end ArrayStack
