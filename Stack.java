public interface Stack<T> {
    /**Adds a new entry to the top of the stack
     * @param newEntry The new entry at the top of the stack
     */
    public void push(T newEntry);

    /**Removes and returns the stack's top entry 
     * @return The top entry of the stack
    */
    public T pop();

    /**Returns the stack's top entry without removal 
     * @return The top entry of the stack
    */
    public T peek();

    /**Detects whether the stack is empty
     * @return True if the stack is empty, false if not
     */
    public boolean isEmpty();

    /**Removes all entries from the stack */
    public void clear();
}
