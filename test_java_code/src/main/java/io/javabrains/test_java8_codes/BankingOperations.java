package main.java.io.javabrains.test_java8_codes;

@FunctionalInterface
interface TransactionProcessor {
    void process(double amount);
}

public class BankingOperations {
    public static void main(String[] args) {
        // Using lambda expression
        TransactionProcessor deposit = amount -> System.out.println("Depositing $" + amount);
        TransactionProcessor withdraw = amount -> System.out.println("Withdrawing $" + amount);

        deposit.process(100.00);  // Output: Depositing $100.0
        withdraw.process(50.00);  // Output: Withdrawing $50.0

        // Using method reference
        TransactionProcessor audit = BankingOperations::auditTransaction;
        audit.process(75.00);  // Output: Auditing transaction of $75.0
    }

    private static void auditTransaction(double amount) {
        System.out.println("Auditing transaction of $" + amount);
    }
}