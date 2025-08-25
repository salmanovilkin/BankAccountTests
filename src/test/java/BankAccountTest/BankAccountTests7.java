import org.example.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTests7 {
    BankAccount account;

    @BeforeEach
    void data (){
        account = new BankAccount("12345","Əli Məmmədov",0.0);
    }
    @DisplayName("Mənfi məbləğ yatırma testi")
    @Test

    void negativeDepositTest(){

        //assertThrows ilə yoxlayırıq ki, mənfi məbləğ (-1000.0) göndərdikdə
        // gözlənilən exception (IllegalArgumentException) yaranır.
        //IllegalArgumentException	Metoda yanlış və ya icazə verilməyən bir arqument (dəyər) ötürüldükdə yaranit
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
        {
            account.deposit(-1000.0);
        });
        // Əlavə olaraq, xəta mesajının da düzgün olduğunu yoxlayırıq
        assertEquals("Məbləğ müsbət olmalıdır!", exception.getMessage());
        System.out.println("Test uğurlu oldu: Mənfi məbləğ yatırılarkən gözlənilən xəta baş verdi.");
    }

    @DisplayName("Mənfi məbləğ çıxartma")
    @Test

    void negativeWithDrawTest(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
        {
            account.withdraw(-1000.0);
        });

        assertEquals("Məbləğ müsbət olmalıdır!", exception.getMessage());
        System.out.println("Test uğurlu oldu: Mənfi məbləğ çıxarılarkən gözlənilən xəta baş verdi.");
    }


    @DisplayName("Kifayətsiz balansla pul çıxarma")
    @Test

    void insufficientBalance(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
        {
            account.withdraw(200);
        });

        assertEquals("Balans kifayət etmir!",exception.getMessage());
        System.out.println("Test uğurlu oldu: Mənfi məbləğ çıxarılarkən gözlənilən xəta baş verdi.");
    }

    @DisplayName("Bağlı hesaba pul yatırma ")
    @Test

    void closeAccountDeposit(){
        //Hesab bağlıdır
        account.closeAccount();
        Exception exception = assertThrows(IllegalStateException.class,()->
        {
         account.deposit(500);
        });
        assertEquals("Hesab aktiv deyil!",exception.getMessage());
        System.out.println("Test uğurlu oldu: Bağlı hesaba pul yatırma  mümkün olmadı xəta baş verdi.");
    }

    @DisplayName("Balansı sıfır olmayan hesabı bağlamaq")
    @Test

    void closeNonZeroBalance(){
        //Hesabda məbləğvar
        account.deposit(500);

        Exception exception = assertThrows(IllegalStateException.class,()->
        {

            account.closeAccount();
        });
        assertEquals("Balans sıfır olmalıdır!",exception.getMessage());
        System.out.println("Test uğurlu oldu: Balansı sıfır olmayan hesabı bağlamaq mümkün olmadı.");

    }

}
