import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.example.BankAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTests4 {
    BankAccount account;
    double initialBalance = 1000.0;


    @BeforeEach
    void setup() {
        account = new BankAccount("12345", "Əli Məmmədov", initialBalance);
    }

    @DisplayName("Müxtəlif məbləğlərlə pul yatırma testi")
    @ParameterizedTest(name = "Depozit: {0} AZN yatırıldıqda balans {0} olmalıdır")
    @ValueSource(doubles = {10.0, 50.0, 100.0, 500.0, 1000.0})

    void testDeposid (double amount){
        account.deposit(amount);
       assertEquals(amount,account.getBalance(),"Balans yatırılan məbləğ qədər olmalıdır: " + amount);

        System.out.println("Test Passed: " + "\n" + account.getBalance() + "AZN");

    }



}
