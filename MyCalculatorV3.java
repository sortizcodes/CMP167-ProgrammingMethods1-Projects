/**
 @author: Samantha
 @date: 10/17/26 5:28PM 
 @version: 3.0
 @description: This program is a basic console based calculator.
 The program operates in two modes (Standard and Scientific) 
 and performs basic arithmetic operations. 
 */

import java.util.Scanner;
public class MyCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); 

        String mymathOperator = ""; 
        String userSelection = ""; 
        boolean myMathOperatorValid = false; 
        boolean startOverYN = true; 
        double result = 0.0; 

        do {
            myMathOperatorValid = false; 

            System.out.println("Select your calculator mode: Standard/Scientific?");
            String mode = "";
            if (input.hasNext()) {  
                mode = input.next();
            } else {
                break; 
            }

            while (!mode.equalsIgnoreCase("Standard") && !mode.equalsIgnoreCase("Scientific")) { 
                System.out.println("Invalid. Please enter 'Standard' or 'Scientific':");

                if (input.hasNext()) {
                    mode = input.next();
                } else {
                    break; 
                }
            }

            if (mode.equalsIgnoreCase("Standard")) { 
                System.out.println("This calculator will operate in Standard mode.");
            } else { 
                System.out.println("This calculator will operate in Scientific mode.");
            }
        
            do {
                if (mode.equalsIgnoreCase("Standard")) { 
                    System.out.println("Please enter an operator such as (+, -, *, /):");   
                } else {
                    System.out.println("Please enter an operator such as (+, -, *, /, 'sin', 'cos', 'tan'):");   
                }

                if (input.hasNext()) { 
                    mymathOperator = input.next();
                } else {
                    break; 
                }

                if (mode.equalsIgnoreCase("Standard")) { 
                    if (mymathOperator.equals("+") || mymathOperator.equals("-") || mymathOperator.equals("*") || mymathOperator.equals("/")) {
                        myMathOperatorValid = true; 
                    } else if (mymathOperator.equalsIgnoreCase("sin") || mymathOperator.equalsIgnoreCase("cos") || mymathOperator.equalsIgnoreCase("tan")) {
                        System.out.println("Invalid. Trigonometric operators are only available in Scientific mode.");
                        myMathOperatorValid = false;
                    } else {
                        System.out.println("Invalid. Please enter a valid operator.");
                        myMathOperatorValid = false;
                    }
                } else { 
                    if (mymathOperator.equals("+") || mymathOperator.equals("-") || mymathOperator.equals("*") || mymathOperator.equals("/") || mymathOperator.equalsIgnoreCase("sin") || mymathOperator.equalsIgnoreCase("cos") || mymathOperator.equalsIgnoreCase("tan")) {
                        myMathOperatorValid = true; 
                    } else {
                        System.out.println("Invalid. Please enter a valid operator.");
                        myMathOperatorValid = false;
                    }    
                }       
            } while (!myMathOperatorValid);

            if (!myMathOperatorValid) {
                break;
            }

            // If the user selects any trigonometric operator like sin cos tan
            if (mymathOperator.equalsIgnoreCase("sin") || mymathOperator.equalsIgnoreCase("cos") || mymathOperator.equalsIgnoreCase("tan")) {
                System.out.println("Enter the angle in radians:");
            
                if (input.hasNextDouble()) {
                    double angle = input.nextDouble();
                    if (mymathOperator.equalsIgnoreCase("sin")) {
                        result = Math.sin(angle);
                    } else if (mymathOperator.equalsIgnoreCase("cos")) {
                        result = Math.cos(angle);
                    } else if (mymathOperator.equalsIgnoreCase("tan")) {
                        result = Math.tan(angle);
                    }
                    System.out.println("Result: " + result);
                } else {
                    break;
                }

            } else { //Standard multi-value arithmetic operations (+, -, *, /)
                System.out.println("How many numbers would you like to calculate today? (Please enter a number greater than 1):");
            
                int numCount = 0; 
                if (input.hasNextInt()) {
                    numCount = input.nextInt();
                } else {
                    break;
                }

                if (numCount > 0) { 
                    System.out.println("Enter number 1:");
                    if (input.hasNextDouble()) {
                        result = input.nextDouble();
                    } else {
                        break;
                    }

                    boolean divisionError = false;
                    for (int i = 2; i <= numCount; i++) {
                        System.out.println("Enter number " + i + ":");
                        if (input.hasNextDouble()) {
                            double nextNum = input.nextDouble();

                            if (mymathOperator.equals("+")) {
                                result += nextNum;
                            } else if (mymathOperator.equals("-")) {
                                result -= nextNum;
                            } else if (mymathOperator.equals("*")) {
                                result *= nextNum;
                            } else if (mymathOperator.equals("/")) {
                                if (nextNum != 0) {
                                    result /= nextNum;
                                } else {
                                    System.out.println("Error: Division by zero!");
                                    divisionError = true;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    if (!divisionError) {
                        System.out.println("Result: " + result);
                    }
                } else {
                    System.out.println("Number count must be greater than 0.");
                }
            }
               
            System.out.println("Would you like to start over?");
            System.out.println("Type Y for yes or N for No");
           
            if (input.hasNext()) {
                userSelection = input.next();
                if (userSelection.equalsIgnoreCase("Y")) {
                    startOverYN = true;
                } else if (userSelection.equalsIgnoreCase("N")) {
                    startOverYN = false;
                }
            } else {
                break;
            }
           
        } while (startOverYN);
       
        System.out.println("Thank you for using the calculator! Goodbye :)");
        input.close();
    }
}
