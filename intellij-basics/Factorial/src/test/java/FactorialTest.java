import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    void shouldReturnOneIfFactorialOfZero() {
        var factorial = new Factorial();
        var result = factorial.calculate(0);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnOneIfFactorialOfOne() {
        var factorial = new Factorial();
        var result = factorial.calculate(1);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnSixIfFactorialOfThree() {
        var factorial = new Factorial();
        var result = factorial.calculate(3);
        assertEquals(6, result);
    }

    @Test
    void shouldReturnExpectedFactorialOfFive() {
        Factorial factorial = new Factorial();
        long result = factorial.calculate(5);
        long expected= 5 * 4 * 3 * 2;
        assertEquals(expected, result);
    }
}
