package main.java.io.javabrains.test_java8_codes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionAnalysis {
    static class Transaction {
        String type;
        double amount;

        Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("DEPOSIT", 100.00),
            new Transaction("WITHDRAW", 50.00),
            new Transaction("DEPOSIT", 75.00),
            new Transaction("WITHDRAW", 25.00)
        );

        // Calculate total deposits
        double totalDeposits = transactions.stream()
            .filter(t -> t.type.equals("DEPOSIT"))
            .mapToDouble(t -> t.amount)
            .sum();
        System.out.println("Total deposits: $" + totalDeposits);

        // Get list of withdrawal amounts
        List<Double> withdrawals = transactions.stream()
            .filter(t -> t.type.equals("WITHDRAW"))
            .map(t -> t.amount)
            .collect(Collectors.toList());
        System.out.println("Withdrawals: " + withdrawals);

        // Check if any transaction is over $1000
        boolean hasLargeTransaction = transactions.stream()
            .anyMatch(t -> t.amount > 1000);
        System.out.println("Has transaction over $1000: " + hasLargeTransaction);
    }
}