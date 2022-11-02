package bank;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

    public static final String DELIMITER = " | ";
    private final Amount amount;
    private final LocalDate date;

    public Transaction(Amount amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Amount balanceAfterTransaction(Amount currentBalance) {
        return currentBalance.plus(amount);
    }

    public void print(PrintStream printer, Amount currentBalance) {
        printer.println(DELIMITER + date + DELIMITER + amount + DELIMITER + currentBalance + DELIMITER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }
}
