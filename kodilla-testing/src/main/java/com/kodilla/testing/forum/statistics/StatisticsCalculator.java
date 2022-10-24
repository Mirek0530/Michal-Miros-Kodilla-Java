package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersCounter;
    private int postsCounter;
    private int commentsCounter;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersCounter = statistics.usersNames().size();
        postsCounter = statistics.postsCount();
        commentsCounter = statistics.commentsCount();

        if (usersCounter > 0) {
            averagePostsPerUser = postsCounter * 1.0 / usersCounter;
            averageCommentsPerUser = commentsCounter * 1.0  / usersCounter;
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }

        if (postsCounter > 0) {
            averageCommentsPerPost = commentsCounter * 1.0 / postsCounter;
        } else {
            averageCommentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println("Users counter: " + usersCounter);
        System.out.println("Posts counter: " + postsCounter);
        System.out.println("Comments counter: " + commentsCounter);
        System.out.println("Posts per user: " + averagePostsPerUser);
        System.out.println("Comments per user: " + averageCommentsPerUser);
        System.out.println("Comments per post: " + averageCommentsPerPost + '\n');
    }

    public int getUsersCounter() {
        return usersCounter;
    }

    public int getPostsCounter() {
        return postsCounter;
    }

    public int getCommentsCounter() {
        return commentsCounter;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
