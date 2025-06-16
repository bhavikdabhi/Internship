import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {
    private static Scanner sc = new Scanner(System.in);
    private static HashMap<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Bank!");
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            int userChoice = sc.nextInt();
            sc.nextLine();

            switch (userChoice) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdrawal();
                    break;
                case 4:
                    displayAccountBalance();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Thank you for using Bank System! Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
        System.out.print("Please choose an option: ");
    }

       private static void createNewAccount() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter a unique account number: ");
        String accountNumber = sc.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Error: An account with this number already exists.");
        } else {
            accounts.put(accountNumber, new BankAccount(accountNumber, name));
            System.out.println("Account created successfully!");
        }
    }

    private static void handleDeposit() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ₹");
            double amount = sc.nextDouble();
            account.deposit(amount);
        }
    }
    private static void handleWithdrawal() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ₹");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        }
    }
  private static void displayAccountBalance() {
        BankAccount account = findAccount();
        if (account != null) {
            account.displayAccountDetails();
        }
    }

      private static BankAccount findAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        } else {
            System.out.println("Error: Account not found.");
            return null;
        }
    }
}

