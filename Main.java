import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> descriptions = new ArrayList<>();
    static ArrayList<Double> amounts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Personal Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total Spending");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    showTotal();
                    break;
                case 4:
                    deleteExpense();
                    break;
                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    static void addExpense() {
        System.out.print("Enter expense description: ");
        String description = sc.nextLine();

        System.out.print("Enter amount: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid amount: ");
            sc.next();
        }
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        descriptions.add(description);
        amounts.add(amount);
        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {
        if (descriptions.isEmpty()) {
            System.out.println("No expenses added yet.");
            return;
        }

        System.out.println("\n--- Your Expenses ---");
        for (int i = 0; i < descriptions.size(); i++) {
            System.out.println((i + 1) + ". " + descriptions.get(i)
                    + " - Rs. " + amounts.get(i));
        }
    }

    static void showTotal() {
        double total = 0;

        for (double amount : amounts) {
            total += amount;
        }

        System.out.println("Total spending: Rs. " + total);
    }

    static void deleteExpense() {
        viewExpenses();

        if (descriptions.isEmpty()) {
            return;
        }

        System.out.print("Enter the expense number to delete: ");
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int number = sc.nextInt();
        sc.nextLine();

        if (number >= 1 && number <= descriptions.size()) {
            descriptions.remove(number - 1);
            amounts.remove(number - 1);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid expense number.");
        }
    }
}
