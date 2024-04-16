import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeNumberCheckerTest {
    @Test
    void ShouldReturnFalseIfTheNumberIsLessThanTwo() {
        var primeNumber = new PrimeNumberChecker(1);

        var checked = primeNumber.check();

        assertFalse(checked);
    }

    @Test
    void ShouldReturnFalseIfTheNumberIsNotPrime() {
        var primeNumber = new PrimeNumberChecker(4);

        var checked = primeNumber.check();

        assertFalse(checked);
    }

    @Test
    void ShouldReturnTrueIfNumberIsPrime() {
        var primeNumber = new PrimeNumberChecker(7);

        var checked = primeNumber.check();

        assertTrue(checked);
    }

}
