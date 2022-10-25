package com.kodilla.rps;

public class RpsResultsDatabase {
    private String playerName;
    private int roundsToWinNumber;
    private int roundsWonByPlayer;
    private int roundsWonByComputer;

    public void clear() {
        playerName = "";
        roundsToWinNumber = 0;
        roundsWonByComputer = 0;
        roundsWonByPlayer = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRoundsToWinNumber() {
        return roundsToWinNumber;
    }

    public void setRoundsToWinNumber(int roundsToWinNumber) {
        this.roundsToWinNumber = roundsToWinNumber;
    }

    public int getRoundsWonByPlayer() {
        return roundsWonByPlayer;
    }

    public void incRoundsWonByPlayer() {
        this.roundsWonByPlayer++;
    }

    public int getRoundsWonByComputer() {
        return roundsWonByComputer;
    }

    public void incRoundsWonByComputer() {
        this.roundsWonByComputer++;
    }
}
