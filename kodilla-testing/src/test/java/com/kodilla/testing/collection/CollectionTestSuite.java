package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterAll
    public static void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("When OddNumbersExterminator exterminate() method has given empty numbers list in argument" +
                " then exterminate() should return list with one argument which is zero"
    )

    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator ode = new OddNumbersExterminator();
        List<Integer> numbers = new ArrayList<>();
        //When
        List<Integer> result = ode.exterminate(numbers);
        System.out.println("Testing testOddNumbersExterminatorEmptyList");
        //Then
        Assertions.assertEquals(result.get(0), numbers.size());
    }

    @DisplayName("When OddNumbersExterminator exterminate() method has given list of numbers" +
                " then exterminate() should return list with even numbers only."
    )

    @Test
    void testOddNumberExterminatorNormalList() {
        //Given
        OddNumbersExterminator ode = new OddNumbersExterminator();
        Integer[] num = new Integer[] {3, 18, 42, 10, 4, 13, 54, 14};
        List<Integer> numbers = Arrays.asList(num);
        //When
        List<Integer> result = ode.exterminate(numbers);
        System.out.println("Testing testOddNumbersExterminatorNormalList");
        //Then
        int countEven = 0;
        for (Integer probablyEven : numbers) {
            if (probablyEven % 2 == 0) {
                countEven++;
            }
        }
        Assertions.assertEquals(result.size(), countEven);
    }
}
