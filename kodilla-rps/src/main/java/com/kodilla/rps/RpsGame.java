package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;


public class RpsGame {
    private RpsPrinter printer;
    private RpsResultsDatabase database;
    private Scanner input;
    private boolean end;
    private int lastPlayerMove;
    private int lastComputerMove;
    private boolean playerRequestedEnd = false;
    private boolean playerRequestedNewGame = false;
    private boolean movePlayed;

    public RpsGame() {
        this.printer = new RpsPrinter();
        this.database = new RpsResultsDatabase();
        input = new Scanner(System.in);
    }

    public void run() {
        end = false;
        database.clear();
        printer.printStartMessage();
        printer.printUsernameRequest();
        database.setPlayerName(input.next());
        printer.printRoundsToWinNumberRequest(database);
        database.setRoundsToWinNumber(input.nextInt());
        printer.printHowToPlay();

        while (!end) {
            movePlayed = false;
            while (!movePlayed && !playerRequestedEnd) {
                printer.printRequestNextMove();
                interpreteInput(input.next());
            }

            if (playerRequestedEnd) break;

            computerMove();
            checkResult(lastPlayerMove, lastComputerMove);
            printer.printInGameResults(database);
            end = isGameOver();
        }

        printer.printEndGameResults(database, playerRequestedEnd);

        if (!playerRequestedEnd) {
            printer.printNewGameRequest();
            interpreteEndGameInput(input.next());
        }
    }

    public void interpreteInput(String s) {
        switch (s.toUpperCase()) {
            case "X" : //end game
                printer.printAreYouSureToEnd();
                playerRequestedEnd = input.next().toUpperCase().equals("Y");
                playerRequestedNewGame = false;
                movePlayed = false;
                break;
            case "N" : //new game
                printer.printAreYouSureToRestart();
                playerRequestedNewGame = input.next().toUpperCase().equals("Y");
                playerRequestedEnd = playerRequestedNewGame;
                movePlayed = false;
                break;
            case "1" :
                lastPlayerMove = 1;
                printer.printLastPlayerMove(1);
                movePlayed = true;
                break;
            case "2" :
                lastPlayerMove = 2;
                printer.printLastPlayerMove(2);
                movePlayed = true;
                break;
            case "3" :
                lastPlayerMove = 3;
                printer.printLastPlayerMove(3);
                movePlayed = true;
                break;
            default:
                printer.printErrorMessage();
                movePlayed = false;
        }
    }

    public void interpreteEndGameInput(String s) {
        switch (s.toUpperCase()) {
            case "X" :
                playerRequestedNewGame = false;
                printer.printGoodbye();
                break;
            case "N" :
                playerRequestedNewGame = true;
                break;
            default:
                printer.printErrorMessage();
        }
    }

    public void computerMove() {
        Random random = new Random();
        lastComputerMove = random.nextInt(3) + 1;
        printer.printLastComputerMove(lastComputerMove);
    }

    public void checkResult(int lastPlayerMove, int lastComputerMove) {
        if (lastPlayerMove == lastComputerMove) {
            printer.printDraw();
        } else if ((lastPlayerMove == 1 && lastComputerMove == 3) ||
                    (lastPlayerMove == 2 && lastComputerMove == 1) ||
                    (lastPlayerMove == 3 && lastComputerMove == 2)) {
                    database.incRoundsWonByPlayer();
                    printer.printPlayerWonRound(database.getPlayerName());
        } else {
            database.incRoundsWonByComputer();
            printer.printComputerWonRound();
        }
    }

    public boolean isGameOver() {
        return (database.getRoundsWonByComputer() >= database.getRoundsToWinNumber()) || (database.getRoundsWonByPlayer() >= database.getRoundsToWinNumber());
    }

    public boolean playerRequestedNewGame() {
        return playerRequestedNewGame;
    }

    public RpsResultsDatabase getDatabase() {
        return database;
    }
}
