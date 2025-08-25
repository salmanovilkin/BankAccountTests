import org.example.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTests2 {

    BankAccount account;

    //2. BeforeEach və AfterEach Anotasiyaları (10 xal)
    //@BeforeEach anotasiyası istifadə edərək:
    //Hər test başlamazdan əvvəl yeni BankAccount obyekti yaradın
    // Obyekti "12345" hesab nömrəsi və "Əli Məmmədov" sahibi ilə yaradın

   // @BeforeEach
//    void setUp(){
//
//        account = new BankAccount("12345","Əli Məmmədov", initialBalance);
//        System.out.println("Yeni bank hesabi yaradildi" +" " + account.getOwnerName());
//    }
//
//    //@AfterEach anotasiyası istifadə edərək:
//    //Hər test bitdikdən sonra obyekti null edin
//    //"Test tamamlandı" mesajını konsola yazdırın
//
//    @AfterEach
//    void tearDown() {
//        account = null;
//        System.out.println("Test tamamlandı");
//    }
//
//    @Test
//    void testOwnerName(){
//        System.out.println("1-ci test başladı");
//        Assertions.assertEquals("Əli Məmmədov",account.getOwnerName());
//    }
//    @Test
//    void teatAccountNumber(){
//        System.out.println("2-ci test başladı");
//        Assertions.assertEquals("12345",account.getAccountNumber());
//    }
//
}
