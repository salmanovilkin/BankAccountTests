package BankAccountTest;

import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTests8 {
    BankAccount toAccount;
    BankAccount fromAccount;
    @BeforeEach
    void data() {
        fromAccount = new BankAccount("12345","Əli Məmmədov",1000.0);
        toAccount = new BankAccount("1234","ilkin  Salmanov",0.0);
    }

    @Test
    @DisplayName("Transfer metodu test")
    @Disabled("Metod hazr deyl")
    void transferTest() {
        fromAccount.transfer(toAccount, 200);
        // Balansları düzgün yoxlayırıq
        assertEquals(800, fromAccount.getBalance()); // 1000 - 200
        assertEquals(200, toAccount.getBalance());   // 0 + 200

        System.out.println("Test uğurlu oldu");
    }





}
