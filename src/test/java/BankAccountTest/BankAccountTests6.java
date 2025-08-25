import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTests6 {
    BankAccount account;

    @RepeatedTest(3) // tedt 3 defe tekrar olacaq
    @DisplayName("3 defe tekrar olunaraq yoxlanilsin")

    void checkInterest (RepetitionInfo repetitionInfo){
        // RepetitionInfo - Unit 5-in verdiyi xüsusi bir obyektdir.
        //Bu obyekt yalnız @RepeatedTest ilə istifadə olunur və testin neçə dəfə işlədiyini göstərmək üçündür.
        account = new BankAccount("12345","Əli Məmmədov",0.0);

        //1000 azn depozit yatirilir
        account.deposit(1000);

        //faizi hesablamaq

        double interest =account.calculateMonthlyInterest();
        assertEquals(20.0, interest, "Faiz düzgün hesablanmayıb!");

        System.out.println("Faiz testi işləyir: "
                + repetitionInfo.getCurrentRepetition()
                + " / " + repetitionInfo.getTotalRepetitions());


    }


}
