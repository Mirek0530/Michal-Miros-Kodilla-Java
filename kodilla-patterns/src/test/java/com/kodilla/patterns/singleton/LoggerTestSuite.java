package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void beforeAll() {
        logger = Logger.LOGGER;
        logger.log("Something happened.");
    }

    @Test
    void testGetLastLog() {
        //Given

        //When
        String lastLog = logger.getLastLog();

        //Then
        assertEquals("Something happened.", lastLog);
    }
}
