package fr.hetic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubtractionTest {
    private Subtraction subtraction;

    @BeforeEach
    public void setup() {
        subtraction = new Subtraction();
    }

    @Test
    public void shouldReturnDifferenceWhenTwoPositiveNumbersAreProvided() {
        String result = String.valueOf(subtraction.execute(5, 3));
        assertEquals("2", result);
    }

    @Test
    public void shouldReturnDifferenceWhenPositiveAndNegativeNumbersAreProvided() {
        String result = String.valueOf(subtraction.execute(5, -3));
        assertEquals("8", result);
    }

    @Test
    public void shouldReturnDifferenceWhenTwoNegativeNumbersAreProvided() {
        String result = String.valueOf(subtraction.execute(-5, -3));
        assertEquals("-2", result);
    }
}
