package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] arrayOfNumbers = {14, 9, 7, 12, 5, 3, 51, 85, 15, 23, 53, 26, 95, 43, 63, 26, 12, 67, 91, 25};

        //When
        double result = ArrayOperations.getAverage(arrayOfNumbers);

        //Then
        assertEquals(36.25 , result);
    }
}
