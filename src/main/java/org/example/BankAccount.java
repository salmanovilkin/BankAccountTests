
package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private List<String> transactionHistory;
    private boolean isActive;

    // Constructor
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        this.isActive = true;
        addTransaction("Hesab açıldı: " + ownerName);
    }
    // Pul yatırma
    public boolean deposit(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Hesab aktiv deyil!");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Məbləğ müsbət olmalıdır!");
        }
        balance += amount;
        addTransaction("Depozit: +" + amount + " AZN");
        return true;

    }
    // Pul çıxarma
    public boolean withdraw(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Hesab aktiv deyil!");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Məbləğ müsbət olmalıdır!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Balans kifayət etmir!");
        }
        balance -= amount;
        addTransaction("Çıxarma: -" + amount + " AZN");
        return true;
    }
    // Pul köçürme
    public boolean transfer(BankAccount targetAccount, double amount) {
        if (targetAccount == null) {
            throw new IllegalArgumentException("Hədəf hesab null ola bilməz!");
        }
        if (!targetAccount.isActive()) {
            throw new IllegalStateException("Hədəf hesab aktiv deyil!");
        }

        this.withdraw(amount);
        targetAccount.deposit(amount);

        addTransaction("Köçürmə: -" + amount + " AZN -> " + targetAccount.getAccountNumber());
        targetAccount.addTransaction("Köçürmə alındı: +" + amount + " AZN <- " + this.accountNumber);

        return true;
    }
    // Faiz hesablama (aylıq %2)
    public double calculateMonthlyInterest() {
        if (!isActive || balance <= 0) {
            return 0.0;
        }
        return balance * 0.02;
    }
    // Faiz əlavə etmə
    public void addInterest() {
        double interest = calculateMonthlyInterest();
        if (interest > 0) {
            balance += interest;
            addTransaction("Faiz əlavə edildi: +" + interest + " AZN");
        }
    }
    // Hesabı bağlama
    public void closeAccount() {
        if (balance > 0) {
            throw new IllegalStateException("Balans sıfır olmalıdır!");
        }
        isActive = false;
        addTransaction("Hesab bağlandı");
    }
    // Hesabı yenidən açma
    public void reopenAccount() {
        if (isActive) {
            throw new IllegalStateException("Hesab artıq aktiv!");
        }
        isActive = true;
        addTransaction("Hesab yenidən açıldı");
    }
    // Tranzaksiya əlavə etmə
    private void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
    // Getter metodları
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';

    }
}