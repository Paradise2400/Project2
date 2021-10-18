package src.main;

/**
 * A class in which the entries are stored in a chain of nodes.
 */
public class LinkedStack<T> implements StackInterface<T> {

    Node<T> topNode;

    public LinkedStack() {
        topNode = null;
    } //end default constructor

    /**Adds a new entry to the top of the stack
     * @param newEntry The new entry at the top of the stack
     */
    public void push(T newEntry) {
        topNode = new Node<T>(newEntry, topNode);
    } //end push

    /**Removes and returns the stack's top entry 
     * @return The top entry of the stack
    */
    public T pop() {
        if (topNode == null)
            return null;
        T data = topNode.getData();
        topNode = topNode.getNext();
        return data;
    } //end pop

    /**Returns the stack's top entry without removal 
     * @return The top entry of the stack
    */
    public T peek() {
        if (topNode == null)
            return null;
        return topNode.getData();
    } //end peek

    /**Detects whether the stack is empty
     * @return True if the stack is empty, false if not
     */
    public boolean isEmpty() {
        return topNode == null;
    } //end isEmpty

    /**Removes all entries from the stack */
    public void clear() {
        topNode = null;
    } //end clear

    public String toString() {
        if (isEmpty())
            return " ";

        Node<T> curNode = topNode;
        String str = "";
        while (curNode.next != null) {
            str += curNode.data + "  ";
            curNode = curNode.next;
        }
        return str;
    }
} //end LinkedStack
