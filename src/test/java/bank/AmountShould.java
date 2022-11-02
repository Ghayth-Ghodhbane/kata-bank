package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AmountShould {

    private Amount sut;

    @BeforeEach
    public void init() {
        sut = new Amount(50);
    }

    @Test
    void displayFormattedValue() {
        String formattedAmount = sut.toString();

        assertThat(formattedAmount).isEqualTo("50,00");
    }

    @Test
    void returnNegativeAmount() {
        Amount negativeAmount = sut.negative();

        assertThat(negativeAmount).isEqualTo(new Amount(-50));
    }
}
