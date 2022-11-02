package bank.acceptancetests;

import bank.Account;
import bank.Amount;
import bank.Statement;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

class BankAcceptanceTest {

    private PrintStream printer = mock(PrintStream.class);

    @Test
    void printStatement() {
        Account account = new Account(new Statement());

        account.deposit(new Amount(100), LocalDate.of(2020, 01, 01));
        account.deposit(new Amount(200), LocalDate.of(2020, 01, 02));
        account.withdraw(new Amount(50), LocalDate.of(2020, 01, 03));

        account.printStatement(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).println(" | Date       | Amount | Balance| ");
        inOrder.verify(printer).println(" | 2020-01-03 | -50,00 | 250,00 | ");
        inOrder.verify(printer).println(" | 2020-01-02 | 200,00 | 300,00 | ");
        inOrder.verify(printer).println(" | 2020-01-01 | 100,00 | 100,00 | ");
    }

}
