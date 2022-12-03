package com.kodilla.good.patterns.challenges;

public class User {
    private int userId;
    private String userName;
    private String emailAddress;

    public User(int userId, String userName, String emailAddress) {
        this.userId = userId;
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "\"" + userName + "\"";
    }
}
