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


