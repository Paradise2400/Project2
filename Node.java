public class Node<T> {
    
    Node<T> next;
    T data;

    public Node(T data, Node<T> next) {
        this.next = next;
        this.data = data;
    } //end constructor w/next included

    public Node(T data) {
        this.data = data;
        next = null;
    } //end constructor w/o next

    public void setData(T data) {
        this.data = data;
    } //end setData

    public void setNext(Node<T> next) {
        this.next = next;
    } //end setNext

    public T getData() {
        return data;
    } //end getData

    public Node<T> getNext() {
        return next;
    } //end getNext

}
