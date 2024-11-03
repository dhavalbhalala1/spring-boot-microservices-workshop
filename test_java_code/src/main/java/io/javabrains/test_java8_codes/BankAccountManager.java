package main.java.io.javabrains.test_java8_codes;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankAccountManager {
    private static final ConcurrentHashMap<String, Double> accounts = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // Initialize some accounts
        accounts.put("12345", 1000.00);
        accounts.put("67890", 2000.00);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Simulate concurrent operations
        executor.submit(() -> updateBalance("12345", 500.00));
        executor.submit(() -> updateBalance("67890", -200.00));
        executor.submit(() -> System.out.println("Account 12345 balance: " + getBalance("12345")));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Print final balances
        accounts.forEach((k, v) -> System.out.println("Account " + k + " final balance: " + v));
    }

    private static void updateBalance(String accountId, double amount) {
        accounts.compute(accountId, (k, v) -> v + amount);
    }

    private static double getBalance(String accountId) {
        return accounts.getOrDefault(accountId, 0.0);
    }
}