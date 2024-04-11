package fr.hetic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTest {
    private Multiplication multiplication;

    @BeforeEach
    public void setup() {
        multiplication = new Multiplication();
    }

    @Test
    public void shouldReturnProductWhenTwoPositiveNumbersAreProvided() {
        String result = String.valueOf(multiplication.execute(5, 3));
        assertEquals("15", result);
    }

    @Test
    public void shouldReturnProductWhenPositiveAndNegativeNumbersAreProvided() {
        String result = String.valueOf(multiplication.execute(5, -3));
        assertEquals("-15", result);
    }

    @Test
    public void shouldReturnProductWhenTwoNegativeNumbersAreProvided() {
        String result = String.valueOf(multiplication.execute(-5, -3));
        assertEquals("15", result);
    }

    @Test
    public void shouldReturnZeroWhenZeroAndAnyNumberAreProvided() {
        String result = String.valueOf(multiplication.execute(0, 5));
        assertEquals("0", result);
    }
}
