package com.kodilla.rps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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
        int computerPoints = rpsGame.getDatabase().getRoundsWonByComputer();
        int playerPoints = rpsGame.getDatabase().getRoundsWonByPlayer();

        //When
        int player1Move = 1;
        int player2Move = 1;
        rpsGame.checkResult(player1Move, player2Move);

        //Then
        assertEquals(0, computerPoints);
        assertEquals(0, playerPoints);
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
