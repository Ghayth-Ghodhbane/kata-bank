package bank;

import java.time.LocalDate;

public class Bank {

    public static void main(String[] args) {

        Account account = new Account(new Statement());

        account.deposit(new Amount(100), LocalDate.of(2020, 1, 1));
        account.deposit(new Amount(200), LocalDate.of(2020, 1, 2));
        account.withdraw(new Amount(50), LocalDate.of(2020, 1, 3));

        account.printStatement(System.out);
    }
}
