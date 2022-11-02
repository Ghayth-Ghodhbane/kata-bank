package bank;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Statement {

    private static final String HEADER = " | Date       | Amount | Balance| ";

    private final List<StatementLine> statementLines = new LinkedList<>();

    public void addLine(Transaction transaction, Amount currentBalance) {
        statementLines.add(0, new StatementLine(transaction, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printer.println(HEADER);
        printStatementLines(printer);
    }

    private void printStatementLines(PrintStream printer) {
        for (StatementLine statementLine : statementLines) {
            statementLine.printTo(printer);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(statementLines, statement.statementLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementLines);
    }
}
