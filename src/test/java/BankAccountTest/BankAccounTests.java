import org.example.BankAccount;
import org.junit.jupiter.api.*;

/**
 *
 */
public class BankAccounTests {
    private BankAccount account;

    //1. BeforeAll və AfterAll Anotasiyaları (10 xal)
     //@BeforeAll anotasiyası istifadə edərək:
     //Bütün testlər başlamazdan əvvəl "Bank sistemi başladı" mesajını konsola yazdırın
     //Static metod olmalıdır
     @BeforeAll
     static void tc001(){
         System.out.println("Bank sistemi başladı");
     }

     //@AfterAll anotasiyası istifadə edərək:
     //Bütün testlər bitdikdən sonra "Bank sistemi bağlandı" mesajını konsola yazdırın
     //Static metod olmalıdır
     @AfterAll
     static void tc002(){
         System.out.println("Bank sistemi bağlandı");

     }
     @Test
     void tc003(){
         System.out.println("1-ci test işləyir");
     }
     @Test
     void tc004 (){
        System.out.println("2-ci test işləyir");
     }
}
