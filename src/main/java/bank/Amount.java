package bank;

import java.util.Objects;

public class Amount {

    private final double value;

    public Amount(double value) {
        this.value = value;
    }

    public Amount negative() {
        return new Amount(-value);
    }

    public Amount plus(Amount otherAmount) {
        return new Amount(this.value + otherAmount.value);
    }
    
    @Override
    public String toString() {
        return String.format("%,.2f", value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Double.compare(amount.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
