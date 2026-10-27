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

    //Added a Scanner to allow for user inputs
    Scanner input = new Scanner(System.in); 


    String mymathOperator = ""; //Used for math operator symbol
    String userSelection = ""; //Used to ask the user choice to continue or exit calcultor (Y/N)
    boolean myMathOperatorValid = false; //Checks to see if the math operator symbol is valid
    boolean startOverYN = true; //Checks to see if the user wants to continue the program
    double result = 0.0; //Holds the answer based on the calculations 
        

    printWelcomeBanner(); //Prints the welcome banner thats located at the bottom of the program
  
    //User input section to get a custom greeting at the start of calculator program
    System.out.print("Hello, before we begin, please enter your name: ");
    String userName = input.nextLine();
    System.out.println("Welcome, " + userName + "!");

    //Main loop to allow the user to continue using the calculator until they choose to leave
    do {
       myMathOperatorValid = false; //Loops back incase an invalid operator is entered by the user

        System.out.println("Select your calculator mode: Standard/Scientific?"); //Prompts user to select calculator mode
        String mode = "";
        if (input.hasNext()) {  //User input for calculator mode
            mode = input.next();
        } else {
            break; //Exits if no input is provided
        }

        while (!mode.equalsIgnoreCase("Standard") && !mode.equalsIgnoreCase("Scientific")) { //Checks to see if the user input is valid
            System.out.println("Invalid. Please enter 'Standard' or 'Scientific':");

        if (input.hasNext()) {
                mode = input.next();
        } else {
                break; //Exits if no input is provided
            }
        }

        if (mode.equalsIgnoreCase("Standard")) { //If the user selects Standard mode
            System.out.println("This calculator will operate in Standard mode.");
        } else { //If the user selects Scientific mode
            System.out.println("This calculator will operate in Scientific mode.");
        }
        
        do {
            if (mode.equalsIgnoreCase("Standard")) { //If the user selects Standard mode
             System.out.println("Please enter an operator such as (+, -, *, /):");   
        } else {
             System.out.println("Please enter an operator such as (+, -, *, /, 'sin', 'cos', 'tan'):");   //Covers the scientific mode operators
            }


        if (input.hasNext()) { //User input for math operator
            mymathOperator = input.next();
            } else {
                break; //Exits if no input ias provided or if an invalid input is provided 
            }

           if (mode.equalsIgnoreCase("Standard")) { //If the user selects Standard mode
              if (mymathOperator.equals("+") || mymathOperator.equals("-") || mymathOperator.equals("*") || mymathOperator.equals("/")) {
                myMathOperatorValid = true; //Checks to see if the math operator symbol is valid
           } else if (mymathOperator.equalsIgnoreCase("sin") || mymathOperator.equalsIgnoreCase("cos") || mymathOperator.equalsIgnoreCase("tan")) {
                    System.out.println("Invalid. Trigonometric operators are only available in Scientific mode.");
                   myMathOperatorValid = false;
            } else {
                    System.out.println("Invalid. Please enter a valid operator.");
                    myMathOperatorValid = false;
                }



            } else { //If the user selects Scientific mode
                if (mymathOperator.equals("+") || mymathOperator.equals("-") || mymathOperator.equals("*") || mymathOperator.equals("/") || mymathOperator.equalsIgnoreCase("sin") || mymathOperator.equalsIgnoreCase("cos") || mymathOperator.equalsIgnoreCase("tan")) {
                    myMathOperatorValid = true; //Checks to see if the math operator symbol is valid
                } else {
                    System.out.println("Invalid. Please enter a valid operator.");
                    myMathOperatorValid = false;
                }    
            }       
        } while (!myMathOperatorValid);

        // If the user selects a any trigonometric operator like sin cos tan
        if (mymathOperator.equalsIgnoreCase("sin") || mymathOperator.equalsIgnoreCase("cos") || mymathOperator.equalsIgnoreCase("tan")) {
            System.out.println("Enter the angle in radians:");
            
        while (!input.hasNextDouble()) { //Checks to see if a valid number was entered
                System.out.println("Invalid input. Please enter a valid number:");
                input.next(); //Clears out anything invalid 
            }
            
            double angle = input.nextDouble(); //Holds the value entered by the user input
            
            if (mymathOperator.equalsIgnoreCase("sin")) {
                result = Math.sin(angle);
            } else if (mymathOperator.equalsIgnoreCase("cos")) {
                result = Math.cos(angle);
            } else if (mymathOperator.equalsIgnoreCase("tan")) {
                result = Math.tan(angle);
            }
            
            System.out.println("Result: " + result);

        } else { //Standard multi-value arithmetic operations (+, -, *, /)
            System.out.println("How many numbers would you like to calculate today? (Please enter a number greater than 1):");
            
            int numCount = 0; //Holds the number of inputs the user wants to calculate
            while (!input.hasNextInt()) { //Checks to see if a valid int was entered
                System.out.println("Invalid input. Please enter an integer count:");
                input.next(); //Clears out anything invalid 
            }
            numCount = input.nextInt();

            if (numCount > 0) { //Checks if the num count is valid
                System.out.println("Enter number 1:");
                while (!input.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a number:");
                    input.next();
                }
                result = input.nextDouble();

                for (int i = 2; i <= numCount; i++) {
                    System.out.println("Enter number " + i + ":");
                    while (!input.hasNextDouble()) {
                        System.out.println("Invalid. Please enter a number:");
                        input.next();
                    }
                    
                    double nextNum = input.nextDouble(); //Holds the next number for calculation

                    if (mymathOperator.equals("+")) {
                        result += nextNum;
                    } else if (mymathOperator.equals("-")) {
                        result -= nextNum;
                    } else if (mymathOperator.equals("*")) {
                        result *= nextNum;
                    } else if (mymathOperator.equals("/")) {
                        if (nextNum != 0) { //Checks for division by zero
                            result /= nextNum;
                        } else {
                            System.out.println("Error: Division by zero!");
                        }
                    }
                }
                System.out.println("Result: " + result);
            } else {
                System.out.println("Number count must be greater than 0.");
            }
        }
               
        System.out.println("Would you like to start over?");
        System.out.println("Type Y for yes or N for No");
           
        //Restart choice option for the user to continue using the calculator or exit the program
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

    public static void printWelcomeBanner() {
        System.out.println(" .· + · . · ✧ · . · + · . .· + · . · ✧ · . · + · . "  );
        System.out.println(" ✧                                                 ✧");
        System.out.println(" ✧           WELCOME TO SAMS's CALCULATOR          ✧");
        System.out.println(" ✧            Standard & Scientific Based          ✧");
        System.out.println(" ✧                                                 ✧");
        System.out.println(" .· + · . · ✧ · . · + · . .· + · . · ✧ · . · + · . "  );
    }
}
