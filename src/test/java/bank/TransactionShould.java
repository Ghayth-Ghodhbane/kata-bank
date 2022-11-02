package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TransactionShould {

    PrintStream printer;
    Transaction sut;

    @BeforeEach
    public void init() {
        printer = mock(PrintStream.class);
    }

    @Test
    void printDepositTransaction() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100);
        sut = new Transaction(amount, date);

        sut.print(printer, amount);

        verify(printer).println(" | 2020-01-01 | 100,00 | 100,00 | ");
    }

    @Test
    void printWithdrawTransaction() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100).negative();
        sut = new Transaction(amount, date);

        sut.print(printer, amount);

        verify(printer).println(" | 2020-01-01 | -100,00 | -100,00 | ");
    }

    @Test
    void should_calculate_current_balance_after_deposit() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100);
        sut = new Transaction(amount, date);

        Amount currentValue = sut.balanceAfterTransaction(amount);

        assertThat(currentValue).isEqualTo(new Amount(200));
    }

    @Test
    void should_calculate_current_balance_after_withdrawal() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100).negative();

        sut = new Transaction(amount, date);

        Amount currentValue = sut.balanceAfterTransaction(new Amount(100));

        assertThat(currentValue).isEqualTo(new Amount(0));

    }
}