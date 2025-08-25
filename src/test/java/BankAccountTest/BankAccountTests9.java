package BankAccountTest;

import org.example.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTests9 {
    BankAccount account;
    BankAccount toAccount;

    @BeforeEach
    void setup(){
        account = new BankAccount("12345","Əli Məmmədov",0.0);
    }

    @DisplayName("Nested istifadə edərək testləri qruplara ayırmaq")
    @Nested
    //Nested yaradanda class yaradiriq ve () işarəsini qoymuruq
    class Operations {

        @Test
        @DisplayName("Deposit operations")
        void depositOperations(){
            account.deposit(500.0);
            assertEquals(500.0,account.getBalance(),"Doğru məbləğ daxil edin");
            System.out.println("Balans" + account.getBalance());
            System.out.println("Test passed:Deposit operations");

        }

        @Test
        @DisplayName("Withdraw operations")
        void withdraw(){
            account.deposit(500.0);

            account.withdraw(200.0);
            assertEquals(300.0,account.getBalance(),"Balansda kifayət qədər məbləğ yoxdur");

            System.out.println("Balans" + account.getBalance());
            System.out.println("Test passed:Withdraw operations");

        }
        @Test
        @DisplayName("Balans 0 olarsa transfer olmur")
        void zeroBalnceTransfer(){

            Exception exception = assertThrows(IllegalArgumentException.class,()-> {

                account.transfer(toAccount,100);

            });
            assertEquals("Balans kifayet etmir",exception.getMessage());

        }
    }


}
