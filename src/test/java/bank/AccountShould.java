package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountShould {

    private Statement statement;
    private Account sut;

    @BeforeEach
    public void init() {
        statement = mock(Statement.class);
        sut = new Account(statement);
    }

    @Test
    void addDepositLineToStatement() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100);

        sut.deposit(amount, date);

        verify(statement).addLine(new Transaction(amount, date), amount);
    }

    @Test
    void addWithdrawLineToStatement() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100);

        sut.withdraw(amount, date);

        verify(statement).addLine(new Transaction(amount.negative(), date), amount.negative());
    }

    @Test
    void should_print_statement() {
        PrintStream printer = System.out;

        sut.printStatement(printer);

        verify(statement).printTo(printer);
    }
}
