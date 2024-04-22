package org.example;

public class BankAccount {
    private double balance = 0.0;

    public double getBalance() {
        return balance;
    }

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
    }

    public static void main(String[] args) {
        System.out.println("Ignore me! Look at the tests instead.");
    }
}