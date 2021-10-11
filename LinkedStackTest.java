import java.util.*;

public class LinkedStackTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String test = "";
        while (true) {
            System.out.print("\nEnter test input: ");
            test = s.nextLine();
            System.out.println(test +" is balanced:     " + LinkedStack.checkBalance(test));
            System.out.println(test +" operations work: " + LinkedStack.checkOperatorsAndOperands(test));
            System.out.println(test +" in postfix:      " + LinkedStack.convertToPostfix(test));
            }
    }
}
