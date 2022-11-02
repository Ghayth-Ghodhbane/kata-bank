package bank;

import java.io.PrintStream;
import java.time.LocalDate;

public class Account {

    private final Statement statement;
    private Amount balance = new Amount(0);

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(Amount amount, LocalDate date) {
        addTransaction(amount, date);
    }

    public void withdraw(Amount amount, LocalDate date) {
        addTransaction(amount.negative(), date);
    }

    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }

    private void addTransaction(Amount amount, LocalDate date) {
        Transaction transaction = new Transaction(amount, date);
        balance = transaction.balanceAfterTransaction(balance);
        statement.addLine(transaction, balance);
    }
}
