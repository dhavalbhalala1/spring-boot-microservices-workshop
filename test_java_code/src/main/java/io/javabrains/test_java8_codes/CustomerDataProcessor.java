package main.java.io.javabrains;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomerDataProcessor {
    private static Map<String, Customer> customerDatabase = new HashMap<>();

    static class Customer {
        String id;
        String name;
        Optional<String> email;

        Customer(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = Optional.ofNullable(email);
        }
    }

    public static void main(String[] args) {
        customerDatabase.put("C001", new Customer("C001", "John Doe", "john@example.com"));
        customerDatabase.put("C002", new Customer("C002", "Jane Smith", null));

        String customerId = "C001";
        Optional<Customer> customer = findCustomer(customerId);

        customer.ifPresentOrElse(
            c -> System.out.println("Customer found: " + c.name),
            () -> System.out.println("Customer not found")
        );

        String emailToUse = customer
            .flatMap(c -> c.email)
            .orElse("noemail@bank.com");

        System.out.println("Email to use: " + emailToUse);
    }

    private static Optional<Customer> findCustomer(String id) {
        return Optional.ofNullable(customerDatabase.get(id));
    }
}