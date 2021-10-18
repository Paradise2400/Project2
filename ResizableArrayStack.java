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

    /**
     * Default constructor
     */
    public ResizableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Throws an exception if the input is greater than the DEFAULT_CAPACITY
     * @param initialCapacity which is less than DEFAULT_CAPACTIY
     */
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

    /**
     * Throws an exception if receiving object is not initialized
     */
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    }

    /**
     * Removes stack's top entry
     * @return stack's top entry. Throws an exception if the stack is empty before the operation
     */
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

    /**
     *
     * @return a boolean if the topIndex is less than 0
     */
    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty

    /**
     * Throws an exception if the stack is empty
     * @return Retrieves the stack's top entry without changing the stack in any way
     */
    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    /**
     * Adds a new entry to the top of the stack
     * @param newEntry  An object to be added to the stack.
     * Throws an exception if the stack is not initialized or if this push would result the stack exceeding its predefined capacity
     */
    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry; //Storing the
        topIndex++;
    } // end push

    /**
     * If the stack is full, then double its size.
     * Throw exception if the required capacity is more than the predefine MAX_CAPACITY
     */
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity

    /**
     * Checks if the desired capacity is higher than the predefined MAX_CAPACITY
     * @param capacity integer value
     */
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                    "allowed maximum of " + MAX_CAPACITY);
    }

    /**
     * Removes all the entries from the stack
     */
    public void clear()
    {
        while (!isEmpty()) {
            this.pop();
        }
    } // end clear

} // end ArrayStack
