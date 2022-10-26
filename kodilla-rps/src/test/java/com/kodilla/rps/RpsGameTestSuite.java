package com.kodilla.rps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("Game should be over when rounds won counter equals roundsToWinNumber")
    void testIsGameOver() {
        //Given
        RpsGame rpsGame = new RpsGame();
        rpsGame.getDatabase().setRoundsToWinNumber(3);
        rpsGame.getDatabase().incRoundsWonByPlayer();
        rpsGame.getDatabase().incRoundsWonByPlayer();
        rpsGame.getDatabase().incRoundsWonByPlayer();

        //When
        boolean result = rpsGame.isGameOver();

        //Then
        assertTrue(result);
    }

    @Test
    @DisplayName("Test computerMove method 1000 times - should always return number 1, 2 or 3")
    void testComputerMove() {
        //Given
        List<Integer> computerMoves = new ArrayList<>();

        //When
        for (int i = 0; i < 1000; i++) {
            RpsGame rpsGame = new RpsGame();
            rpsGame.computerMove();
            computerMoves.add(rpsGame.getLastComputerMove());
        }

        //Then
        long counter = IntStream.range(0, computerMoves.size())
                .map(computerMoves::get)
                .filter(n -> (n > 0 && n < 4))
                .count();
        assertEquals(1000, counter);
    }
}
