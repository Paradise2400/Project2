import java.util.*;

public class LinkedStackTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String test = "";
        while (true) {
            test = s.nextLine();
            System.out.println(test +" is balanced:     " + checkBalance(test));
            System.out.println(test +" operations work: " + checkOperators(test));
            System.out.println(test +" in postfix:      " + convertToPostfix(test));
            }
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
        if (!checkOperators(infix)) throw new ArithmeticException("Attempt to pass expression with unbalanced operations through infixToPostfix method");
        
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
    public static boolean checkOperators(String in) {
        //smallest acceptable expression is atleast 3 characters long
        //operand-operator-operand
        if (in.length() < 3) return false;
        //every expression should also be 1 plus a multiple of 2
        if ((in.length() - 1) % 2 != 0) return false;
        //iterate over string
        char prevChar = in.charAt(0);
        char curChar = in.charAt(1);
        char nextChar = in.charAt(2);
        //remove delimeters, should only be called after checkBalance() and replacing delimiters with the same type
        //first and last characters should be variables
        if (isOperator(in.charAt(0))) return false;
        if (isOperator(in.charAt(in.length()-1))) return false;
        in = in.replace("(","").replace(")","");
        for (int i = 3; i < in.length() - 1; i++) {
            if (isOperator(curChar)) {
                if (isOperator(prevChar) || isOperator(nextChar)) return false;
            }
            prevChar = curChar;
            curChar = nextChar;
            nextChar = in.charAt(i);
        }
        return true;
    }

    /**Checks if a character is an operator
     * @param in A char
     * @return Whether that char is a operator
     */
    public static boolean isOperator(char in) {
        return (in == '+' || in == '-' || in == '\\' || in == '/' || in == '*');
    }

    /**Checks if an equation is balanced or not
     * @param in The string input
     * @return Whether the input is a balanced expression
     */
    public static boolean checkBalance(String in) {
        boolean isBalanced = true; //no delimiters = balanced
        LinkedStack<Character> stack = new LinkedStack<Character>();
        char nextChar;

        if (in.length() == 0) 
            return true;
        if (!in.contains("(") && !in.contains("{") && !in.contains("["))
            return true;

        while(isBalanced == true) {
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
                        isBalanced = (openDelimeter == nextChar);
                    }
                    break;
                default:
                    break;
            }
        }
        isBalanced = stack.isEmpty();
        return isBalanced;
    }

}
