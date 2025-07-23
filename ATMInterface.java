import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userId = "user123";
        String userPin = "4321";
        double balance = 5000.00;
        boolean authenticated = false;

        System.out.println("=== Welcome to Simple ATM ===");

        // Login attempt
        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (enteredId.equals(userId) && enteredPin.equals(userPin)) {
            authenticated = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Try again later.");
        }

        // ATM Menu
        while (authenticated) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is ₹%.2f%n", balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("₹%.2f deposited successfully.%n", deposit);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = sc.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.printf("₹%.2f withdrawn successfully.%n", withdraw);
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    authenticated = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 1 to 4.");
            }
        }

        sc.close();
    }
}