//Brukes for å kunne bruker input
import java.util.Scanner;

public class Account {
    //Class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //class constructor
    Account(String cName, String cId){
        customerName = cName;
        customerID = cId;
    }

    //Function for depositing money
    void deposite(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Functoin for withdrawing
    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Function showing the previous transaction
    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        }else {
            System.out.println("No transaction occured");
        }
    }

    void calculateInterest(int years){
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;

        System.out.println("The current interest rate is " + (100*interestRate));
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Function showing main meny
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " +customerName+ "!");
        System.out.println("Your id is: " +customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposite");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transactions");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option){
                // Case A allows user to che ck their account balance
                case 'A':
                    System.out.println("=============================");
                    System.out.println("Balance = $ " +balance);
                    System.out.println("=============================");
                    System.out.println();
                    break;
                // Case B allows the user to deposite money into their account using
                case 'B':
                    System.out.println("Enter an amount to deposite");
                    int amount = scanner.nextInt();
                    deposite(amount);
                    System.out.println();
                    break;
                // Case C allows user to withdraw money
                case 'C':
                    System.out.println("Enter the amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=============================");
                    getPreviousTransaction();
                    System.out.println("=============================");
                    break;
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("=============================");
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, F");
            }
        } while (option != 'F');
            System.out.println("Thank you for banking with us!");


    }



}
