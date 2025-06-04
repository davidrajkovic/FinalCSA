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

