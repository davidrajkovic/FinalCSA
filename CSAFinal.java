import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;



public class BudgetTracker {

    static class Transaction {
        String description;
        double amount;
     Transaction(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }

     public String toString() {
            return description + ": $" + amount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();

        // try loading from file first
        loadTransactions(transactions);

       System.out.println("Welcome to the Budget Tracker!");
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Show Balance");
            System.out.println("4. Save Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

               int choice = scanner.nextInt();
            scanner.nextLine(); // classic fix lol

            if (choice == 1) {
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                System.out.print("Enter amount (positive = income, negative = expense): ");
                double amount = scanner.nextDouble();
                transactions.add(new Transaction(description, amount));
                System.out.println("Transaction added.");
            } 
       else if (choice == 2) {
                System.out.println("\nAll Transactions:");
                for (Transaction t : transactions) {
                    System.out.println(t);
                }
            } 
            else if (choice == 3) {
                double total = 0;
                for (Transaction t : transactions) {
                    total += t.amount;
                }
    System.out.println("Current Balance: $" + total);
            } 
            else if (choice == 4) {
                saveTransactions(transactions);
            } 
            else if (choice == 5) {
                System.out.println("Goodbye!");
                running = false;
            } 
            else {
                System.out.println("Not a valid option.");
       }
        }

        scanner.close();
    }

    // save to a text file
    public static void saveTransactions(ArrayList<Transaction> transactions) {
        try {
            PrintWriter writer = new PrintWriter("transactions.txt");
            for (Transaction t : transactions) {
                writer.println(t.description + "," + t.amount);
            }
     System.out.println("Current Balance: $" + total);
            } 
            else if (choice == 4) {
                saveTransactions(transactions);
            } 
            else if (choice == 5) {
                System.out.println("Goodbye!");
                running = false;
            } 
            else {
                System.out.println("Not a valid option.");
            }
        }

        scanner.close();
    }

    // save to a text file
    public static void saveTransactions(ArrayList<Transaction> transactions) {
        try {
            PrintWriter writer = new PrintWriter("transactions.txt");
            for (Transaction t : transactions) {
                writer.println(t.description + "," + t.amount);
            }
            writer.close();
            System.out.println("Transactions saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    // load from the file at the start
    public static void loadTransactions(ArrayList<Transaction> transactions) {
        try {
            File file = new File("transactions.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
    if (parts.length == 2) {
                    String description = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    transactions.add(new Transaction(description, amount));
                }
            }
            fileScanner.close();
            System.out.println("Transactions loaded from file.");
        } catch (IOException e) {
            System.out.println("No saved transactions found (yet).");
        }
    }
}


