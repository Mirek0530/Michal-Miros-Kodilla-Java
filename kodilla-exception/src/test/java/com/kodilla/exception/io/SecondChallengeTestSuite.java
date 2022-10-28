package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        //Given
        SecondChallenge sc = new SecondChallenge();
        //When
        //Then
        assertAll(
                () -> assertThrows(Exception.class, () -> sc.probablyIWillThrowException(2, 3)),
                () -> assertThrows(Exception.class, () -> sc.probablyIWillThrowException(1, 1.5)),
                () -> assertThrows(Exception.class, () -> sc.probablyIWillThrowException(5, 1.5)),
                () -> assertDoesNotThrow(() -> sc.probablyIWillThrowException(1, 2))
        );
    }
}
