package fr.hetic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {
    private Addition addition;

    @BeforeEach
    public void setup() {
        addition = new Addition();
    }

    @Test
    public void shouldReturnSumWhenTwoPositiveNumbersAreProvided() {
        String result = String.valueOf(addition.execute(5, 3));
        assertEquals("8.0", result);
    }

    @Test
    public void shouldReturnSumWhenPositiveAndNegativeNumbersAreProvided() {
        String result = String.valueOf(addition.execute(5, -3));
        assertEquals("2.0", result);
    }

    @Test
    public void shouldReturnSumWhenTwoNegativeNumbersAreProvided() {
        String result = String.valueOf(addition.execute(-5, -3));
        assertEquals("-8.0", result);
    }
}
