import java.util.Scanner;
import java.util.Arrays;
public class BankAccounts {
    public static void main(String[] args){
        String[] nameArray = new String[99];
        double[] moneyArray = new double[99];
        choose(nameArray, moneyArray);
    }

    public static void choose(String[] nameArray, double[] moneyArray){
        Scanner input = new Scanner(System.in);
        int i = 0;
        char selection;
        System.out.println("Welcome!"); 
        do {
            System.out.println("Please choose an option: [n]ew account, [d]isplay balance, [a]dd to balance, [q]uit:");
            selection = input.next().charAt(0);

            if(selection == 'n'){
                newAccount(nameArray, moneyArray, i);
                i++;
            }
            else if(selection == 'd'){
                displayBalance(nameArray, moneyArray);
            }
            else if (selection == 'q'){
                System.out.println("Thank you.");
            }
            else if (selection == 'a'){
                addBalance(nameArray, moneyArray);
            }
            else{
                System.out.println("Please enter a valid input.");
            }
        } 
        while(selection != 'q');
    }

    public static void newAccount(String[] nameArray, double[] moneyArray, int i){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        System.out.print("Enter a balance: ");
        double balance = input.nextDouble();
        
        nameArray[i] = name;
        moneyArray[i] = balance;
    }

    public static void displayBalance(String[] nameArray, double[] moneyArray){
        int index = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        for (int i = 0; i< nameArray.length; i++) {
            if (nameArray[i].equals(name)) {
                index = i;
                break;
            }
        }
        double balance = moneyArray[index];
        System.out.print("Balance for " + name + " is $");
        System.out.printf("%.2f", balance);
        System.out.println();
    }

    public static void addBalance(String[] nameArray, double[] moneyArray){ //Part 2 this method was added to allow user to add money to balance
        
        int index = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        for (int i = 0; i< nameArray.length; i++) {
            if (nameArray[i].equals(name)) {
                index = i;
                break;
            }
        }
        double balance = moneyArray[index];
        System.out.println("Please enter the amount you want deposited: ");
        double deposit = input.nextDouble();
        balance += deposit;
        moneyArray[index] = balance;
    }
    
}