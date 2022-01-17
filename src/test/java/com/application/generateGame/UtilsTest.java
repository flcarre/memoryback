package com.application.generateGame;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UtilsTest {
    private final Utils utils = new Utils();

    @Test
    public void generate_random_number() {
        for(int i = 0; i < 100; i++) {
            int number = utils.generateRandomNumber(10);
            if(number > 10) fail("number exceed range");
        }
    }

    @Test
    public void should_return_true_if_tested_array_contain_value() {
        List<Integer> testedArray = List.of(1, 2);
        int value = 2;

        boolean received = utils.contains(testedArray, value);
        assertTrue(received);
    }

    @Test
    public void should_return_true_if_tested_array_contain_value_with_0() {
        List<Integer> testedArray = List.of(0, 2);
        int value = 0;

        boolean received = utils.contains(testedArray, value);
        assertTrue(received);
    }

    @Test
    public void should_return_false_if_tested_array_not_contain_value() {
        List<Integer>  testedArray = List.of(0, 1);
        int value = 2;

        boolean received = utils.contains(testedArray, value);
        assertFalse(received);
    }

    @Test
    public void should_return_false_if_tested_array_not_contain_value_with_0() {
        List<Integer>  testedArray = List.of(2, 1);
        int value = 0;

        boolean received = utils.contains(testedArray, value);
        assertFalse(received);
    }
}
