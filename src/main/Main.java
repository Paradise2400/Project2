package src.main;

import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int initialCapacity = 5;

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        String stringInput;
        System.out.println("Choose\n" +
                "1 to enter a start\n" +
                "0 to exit: \n");
        while (!quit) {
            boolean hasNextInt = scanner.hasNextInt(); //returns true if the scanner's input is an integer
            if (hasNextInt) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("You have left the program.");
                        quit = true;
                        break;
                    case 1:
                        System.out.print("Choose an option below:\n" +
                                "\n1. CheckBalance (If the brackets match)" +
                                "\n2. Convert Infix to Postfix Expression" +
                                "\n3. Evaluate Postfix (a=2, b=3, c=4, d=5, e=6: \n");
                        hasNextInt = scanner.hasNextInt();
                        if (hasNextInt) {
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            if (choice == 1) {
                                System.out.println("Please enter a string to check the balance of the expression: ");
                                stringInput = scanner.nextLine();
                                checkBalance(stringInput);
                                break;
                            } else if (choice == 2) {
                                System.out.println("Please enter a string in infix form to calculate the postfix expression: ");
                                stringInput = scanner.nextLine();
                                calcPostfix(stringInput);
                                break;
                            } else if (choice == 3) {
                                System.out.println("Please enter a string in postfix form to be evaluated: ");
                                stringInput = scanner.nextLine();
                                evalPostfix(stringInput);
                                break;
                            }
                        } else {
                            throw new IllegalArgumentException("Please enter an integer: 1,2 or 3");
                        }
                }
            } else {
                System.out.println("Unable to parse choice: Please enter an integer of choice");
                throw new IllegalArgumentException("Please enter an integer of choice");
            }
        }
    }


    private static void checkBalance(String stringInput){
        CalcPostfixEval postfixFunc = new CalcPostfixEval();
        boolean check = postfixFunc.checkBalance(stringInput);
        if(check)
            System.out.println("The expression is balanced");
        else
            System.out.println("The expression is not balanced. Please try again.\n");
    }

    private static void calcPostfix(String stringInput)
    {
        CalcPostfixEval postfixFunc = new CalcPostfixEval();
        String postfix = postfixFunc.convertToPostfix(stringInput);
        System.out.println("The postfix expression is: " + postfix + "\n");
    }

    private static void evalPostfix(String stringInput)
    {
        CalcPostfixEval postfixFunc = new CalcPostfixEval();
        int postfixVal = postfixFunc.evaluatePostfix(stringInput);
        System.out.println("The value of the postfix expression is: " + postfixVal + "\n");
    }


}