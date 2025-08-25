import org.example.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTests5 {
BankAccount account;

@BeforeEach

void  check(){
    account = new BankAccount("12345","Əli Məmmədov",0.0);
}

@ParameterizedTest
    @CsvSource({
            "200.0, 50.0, 150.0", // 200den 50-i cıx = 150
            "1000.0, 250.0, 750.0" // 1000 den 250-i cix = 750
    })
    @DisplayName ("Withdraw əməliyyatını yoxlama")


    void withDraw (double initialBalance, double withdrawAmount, double excpectedBalance  ){
    BankAccount account = new BankAccount("12345","Əli Məmmədov",initialBalance);

    account.withdraw(withdrawAmount);

    assertEquals(excpectedBalance, account.getBalance(),"Balans");

    System.out.println("balans " + "" + account.getBalance());

}
}
