package com.kodilla.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpsGameTestSuite {

    @Test
    void testIfPlayerNameIsSavedCorrectlyInDatabase() {
        //Given
        RpsResultsDatabase rpsResultsDatabase = new RpsResultsDatabase();
        String playerName = "John_Snow22";

        //When
        rpsResultsDatabase.setPlayerName(playerName);

        //Then
        assertEquals(playerName, rpsResultsDatabase.getPlayerName());
    }

    @Test
    void testIfCalculatedScoreDoesNotChangeAfterDraw() {
        //Given
        RpsGame rpsGame = new RpsGame();

        //When
        rpsGame.checkResult(1, 1); //both played ROCK

        //Then
        assertEquals(0, rpsGame.getDatabase().getRoundsWonByComputer());
        assertEquals(0, rpsGame.getDatabase().getRoundsWonByPlayer());
    }

    @Test
    void testIfPlayerGetsPointForWin() {
        //Given
        RpsGame rpsGame = new RpsGame();

        //When
        rpsGame.checkResult(1,3); //player played ROCK, computer played SCISSORS

        //Then
        assertEquals(1, rpsGame.getDatabase().getRoundsWonByPlayer());
        assertEquals(0, rpsGame.getDatabase().getRoundsWonByComputer());
    }

    @Test
    void testIfComputerGetsPointForWin() {
        //Given
        RpsGame rpsGame = new RpsGame();

        //When
        rpsGame.checkResult(2, 3); //player played PAPER, computer played SCISSORS

        //Then
        assertEquals(0, rpsGame.getDatabase().getRoundsWonByPlayer());
        assertEquals(1, rpsGame.getDatabase().getRoundsWonByComputer());
    }
}
