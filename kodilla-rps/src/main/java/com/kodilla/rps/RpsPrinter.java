package com.kodilla.rps;

public class RpsPrinter {

    public void printStartMessage() {
        System.out.println("Hello! This is \"Rock-Paper-Scissors\" game!");
    }

    public void printUsernameRequest() {
        System.out.println("What is your name?");
    }

    public void printRoundsToWinNumberRequest(RpsResultsDatabase database) {
        System.out.println("Hi " + database.getPlayerName() + "! How many rounds to win you want to play?");
    }

    public void printHowToPlay() {
        System.out.println("How to play: ");
        System.out.println("Push one of following keys on your keyboard to choose next move");
        System.out.println("\"1\" - play rock");
        System.out.println("\"2\" - play paper");
        System.out.println("\"3\" - play scissors");
        System.out.println("\"x\" - end game");
        System.out.println("\"n\" - new game");
    }

    public void printRequestNextMove() {
        System.out.println("Your turn!");
    }

    public void printInGameResults(RpsResultsDatabase database) {
        System.out.println("First to " + database.getRoundsToWinNumber());
        System.out.println(database.getPlayerName() + "   " + database.getRoundsWonByPlayer() + "   :   " + database.getRoundsWonByComputer() + "    Computer");
    }

    public void printEndGameResults(RpsResultsDatabase database, boolean playerRequestedEnd) {
        if (!playerRequestedEnd) {
            System.out.println("GAME ENDED!");
            if (database.getRoundsWonByPlayer() > database.getRoundsWonByComputer()) {
                System.out.println("You won " + database.getRoundsWonByPlayer() + ":" + database.getRoundsWonByComputer() + ". Congratulations.");
            } else {
                System.out.println("You lost " + database.getRoundsWonByPlayer() + ":" + database.getRoundsWonByComputer() + ". What a shame.");
            }
        } else {
            printGoodbye();
        }
    }

    public void printGoodbye() {
        System.out.println("You ended the game. See you next time.");
    }

    public void printAreYouSureToEnd() {
        System.out.println("Are you sure to end the game? Y/N");
    }

    public void printAreYouSureToRestart() {
        System.out.println("Are you sure to end this game and start a new game? Y/N");
    }

    public void printErrorMessage() {
        System.out.println("You entered wrong parameter! Try again.");
    }

    public void printLastComputerMove(int move) {
        switch (move) {
            case 1 :
                System.out.println("Computer plays ROCK");
                break;
            case 2 :
                System.out.println("Computer plays PAPER");
                break;
            case 3 :
                System.out.println("Computer plays SCISSORS");
                break;
        }
    }

    public void printLastPlayerMove(int move) {
        switch (move) {
            case 1 :
                System.out.println("You played ROCK");
                break;
            case 2 :
                System.out.println("You played PAPER");
                break;
            case 3 :
                System.out.println("You played SCISSORS");
                break;
        }
    }

    public void printDraw() {
        System.out.println("Draw! No score for both players.");
    }

    public void printPlayerWonRound(String playerName) {
        System.out.println(playerName + " won this round!");
    }

    public void printComputerWonRound() {
        System.out.println("Computer won this round!");
    }

    public void printNewGameRequest() {
        System.out.println("Do you want to play again?");
        System.out.println("\"X\" - end game, \"N\" - play again");
    }
}
