package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.*;

class StatementShould {

    private PrintStream printer;
    private Statement sut;

    @BeforeEach
    public void init() {
        printer = mock(PrintStream.class);
        sut = new Statement();
    }

    @Test
    void printHeader() {
        sut.printTo(printer);

        verify(printer).println(" | Date       | Amount | Balance| ");
    }

    @Test
    void printDeposit() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100);
        sut.addLine(new Transaction(amount, date), amount);

        sut.printTo(printer);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(printer, times(2)).println(argument.capture());
    }

    @Test
    void printWithdraw() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        Amount amount = new Amount(100).negative();
        sut.addLine(new Transaction(amount, date), amount);

        sut.printTo(printer);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(printer, times(2)).println(argument.capture());
    }
}