import com.calculator.ScientificCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest {
    private final ScientificCalculator calculator = new ScientificCalculator();

    @Test
    void testSquareRoot() {
        assertEquals(4.0, calculator.squareRoot(16));
        assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-1));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void testNaturalLogarithm() {
        assertEquals(0.0, calculator.naturalLog(1), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> calculator.naturalLog(-1));
    }

    @Test
    void testPower() {
        assertEquals(8.0, calculator.power(2, 3));
    }
}
