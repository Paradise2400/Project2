package src.main;
/**
 * A class that is a node for the linkedStack implementation.
 */
public class Node<T> {
    
    Node<T> next;
    T data;

    /**
     *
     * @param data Object of type <T>
     * @param next Node object
     */
    public Node(T data, Node<T> next) {
        this.next = next;
        this.data = data;
    } //end constructor w/next included

    /**
     * Constructor that sets the next node null
     * @param data
     */
    public Node(T data) {
        this.data = data;
        next = null;
    } //end constructor w/o next

    /**
     * Sets the data of the node to be Object T data
     * @param data object of type T
     */
    public void setData(T data) {
        this.data = data;
    } //end setData

    /**
     * Sets the next node pointing to as the parameter Node next passed in input
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    } //end setNext

    /**
     * Void input.
     * @return data of object type T
     */
    public T getData() {
        return data;
    } //end getData

    /**
     * Gets next node
     * @return a node object
     */
    public Node<T> getNext() {
        return next;
    } //end getNext

}
