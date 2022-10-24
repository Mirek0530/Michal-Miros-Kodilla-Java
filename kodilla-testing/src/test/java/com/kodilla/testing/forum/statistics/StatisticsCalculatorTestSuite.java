package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsCalculatorTestSuite {

    private StatisticsCalculator statisticsCalculator;
    List<String> usersNames;
    int commentsCounter;
    int postsCounter;

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void BeforeEach() {
        statisticsCalculator = new StatisticsCalculator();
        String[] names = {"John123", "Magda12", "Karen_1", "Bruce-ALM", "ReeceTaylor1", "AnnaGreen"};
        usersNames = Arrays.asList(names);
        commentsCounter = 498;
        postsCounter = 24;
    }

    @Test
    void testCalculateAdvStatisticsWhenPostsCounterEqualsZero() {
        //When
        when(statisticsMock.commentsCount()).thenReturn(commentsCounter);
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //Then
        assertEquals(0, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(commentsCounter * 1.0 / usersNames.size(), statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenPostsCounterEquals1000() {
        //When
        when(statisticsMock.commentsCount()).thenReturn(commentsCounter);
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //Then
        assertEquals(1000 * 1.0 / usersNames.size(), statisticsCalculator.getAveragePostsPerUser());
        assertEquals(commentsCounter * 1.0 / usersNames.size(), statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(commentsCounter * 1.0 / 1000, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsCounterEqualsZero() {
        //When
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsCounter);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //Then
        assertEquals(postsCounter * 1.0 / usersNames.size(), statisticsCalculator.getAveragePostsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsCounterIsLessThanPostsCounter() {
        //Given
        while (commentsCounter >= postsCounter) {
            commentsCounter--;
        }

        //When
        when(statisticsMock.commentsCount()).thenReturn(commentsCounter);
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsCounter);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //Then
        assertEquals(postsCounter * 1.0 / usersNames.size(), statisticsCalculator.getAveragePostsPerUser());
        assertEquals(commentsCounter * 1.0 / usersNames.size(), statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(commentsCounter * 1.0 / postsCounter, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsCounterIsGreaterThanPostsCounter() {
        //Given
        while (postsCounter >= commentsCounter) {
            postsCounter--;
        }

        //When
        when(statisticsMock.commentsCount()).thenReturn(commentsCounter);
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsCounter);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //Then
        assertEquals(postsCounter * 1.0 / usersNames.size(), statisticsCalculator.getAveragePostsPerUser());
        assertEquals(commentsCounter * 1.0 / usersNames.size(), statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(commentsCounter * 1.0 / postsCounter, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenUsersCounterEqualsZero() {
        //When
        when(statisticsMock.commentsCount()).thenReturn(commentsCounter);
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
        when(statisticsMock.postsCount()).thenReturn(postsCounter);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //Then
        assertEquals(0, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(0, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(commentsCounter * 1.0 / postsCounter, statisticsCalculator.getAverageCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenUsersCounterEquals100() {
        //Given
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i <= 99; i++) {
            usersList.add("User" + i);
        }

        //When
        when(statisticsMock.commentsCount()).thenReturn(commentsCounter);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsCounter);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        statisticsCalculator.showStatistics();

        //Then
        assertEquals(postsCounter * 1.0 / 100, statisticsCalculator.getAveragePostsPerUser());
        assertEquals(commentsCounter * 1.0 / 100, statisticsCalculator.getAverageCommentsPerUser());
        assertEquals(commentsCounter * 1.0 / postsCounter, statisticsCalculator.getAverageCommentsPerPost());
    }
}
