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

        Node curNode = topNode;
        String str = "";
        while (curNode.next != null) {
            str += curNode.data + "  ";
            curNode = curNode.next;
        }
        return str;
    }

    /**Converts an infix expression as a String into a postfix expression as a String 
     * @param infix The infix expression
     * @return The postfix expression
    */
    public static String convertToPostfix(String infix) {
        String postfix = "";
        LinkedStack<Character> operatorStack = new LinkedStack<Character>();
        
        //checking input
        //if the input is unbalanced, throw exception 
        if (!checkBalance(infix)) throw new ArithmeticException("Attempt to pass unbalanced expression through infixToPostfix method");
        //now that it is balanced, you can replace everything that's a delimiter with a parentheses
        infix = infix.replace("]",")").replace("}",")").replace("[","(").replace("{","(");
        //remove whitespace
        infix = infix.replace(" ","").replace("\n","").replace("\t","");
        //if the input has too many operators, too few, etc., throw exception
        if (!checkOperatorsAndOperands(infix)) throw new ArithmeticException("Attempt to pass expression with operator or operand error through infixToPostfix method");
        //if the 
        
        char nextChar;
        while (infix.length() > 0) {
            //get next char, remove next char
            nextChar = infix.charAt(0);
            infix = infix.substring(1);
            /*Cases
            ^       |   Push onto stack
            *       |   Pop exponetation into postfix, push onto stack
            /       |   Pop exponetation into postfix, push onto stack
            +       |   Pop multi, div, and exp into postfix push
            -       |   Pop multi, div, and exp into postfix push
            (       |   Push
            )       |   Pop operators until '(' or nothing is left
            other   |   Append onto postfix
            */

            switch (nextChar) {
                case '^':
                    operatorStack.push(nextChar);
                    break;

                case '*': case '/': case '\\':
                    while (operatorStack.peek() != null && operatorStack.peek() == '^') 
                        postfix += operatorStack.pop();
                    operatorStack.push(nextChar);
                    break;

                case '+': case '-':
                    while (operatorStack.peek() != null && 
                        (operatorStack.peek() == '^' || operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '\\'))
                        postfix += operatorStack.pop();
                    operatorStack.push(nextChar);
                    break;

                case '(':
                    operatorStack.push(nextChar);
                    break;

                case ')':
                    while (operatorStack.peek() != null && operatorStack.peek() != '(') 
                        postfix += operatorStack.pop();
                    operatorStack.pop();
                    break;

                default:
                    postfix += nextChar;
                    break;
            }
        }
        while (!operatorStack.isEmpty())
            postfix += operatorStack.pop();

        return postfix;
    } //end infixToPostfix

    /**Checks if an equation has unbalanced operators and variables 
     * @param in The string input
     * @return Whether the input's operators are balanced
    */
    protected static boolean checkOperatorsAndOperands(String in) {
        //remove delimeters, should only be called after checkBalance() and replacing delimiters with the same type
        in = in.replace("(","").replace(")","");
        //smallest acceptable expression is atleast 3 characters long
        //operand-operator-operand
        
        //every expression's length should be odd and greater or equal to 3
        if (in.length() < 3) return false;
        if ((in.length() - 1) % 2 != 0) return false;
        
        //iterate over string
        //pattern should be letter-operation-l-o-l-o-l-...-l-o
        //this pattern should end and start with the same type in an odd length
        boolean letterNotOperator = true;
        char curChar;
        for (int i = 0; i < in.length(); i++) {
            curChar = in.charAt(i);
            if (letterNotOperator) {
                if (!Character.isLetter(curChar)) return false;
            } else {
                if (!isOperator(curChar)) return false;
            }

            //switch expected type
            letterNotOperator = !letterNotOperator;
        }

        return true;
    }

    /**Checks if a character is an operator
     * @param in A char
     * @return Whether that char is a operator
     */
    private static boolean isOperator(char in) {
        return (in == '+' || in == '-' || in == '\\' || in == '/' || in == '*' || in == '^');
    }

    /**Checks if an equation is balanced or not
     * @param in The string input
     * @return Whether the input is a balanced expression
     */
    protected static boolean checkBalance(String in) {
        boolean isBalanced = true; //no delimiters = balanced
        LinkedStack<Character> stack = new LinkedStack<Character>();
        char nextChar;

        if (in.length() == 0) 
            return true;
        if (!in.contains("(") && !in.contains("{") && !in.contains("["))
            return true;

        while(isBalanced == true && in.length() > 0) {
            nextChar = in.charAt(0);
            in = in.substring(1);

            switch (nextChar) {
                case '(': case '{': case '[':
                    stack.push(nextChar);
                    break;
                case ')': case '}': case ']':
                    if (stack.isEmpty()) isBalanced = false;
                    else {
                        char openDelimeter = stack.pop();
                        if ((openDelimeter == '[' && nextChar == ']') || (openDelimeter == '(' && nextChar == ')') || (openDelimeter == '{' && nextChar == '}'))
                            isBalanced = true;
                        else
                            isBalanced = false;
                    }
                    break;
                default:
                    break;
            }
        }
        isBalanced = stack.isEmpty();
        return isBalanced;
    }

    public int evaluatePostfix(String input) {
        return ResizableArrayStack.evaluatePostfix(input);
    }
} //end LinkedStack
