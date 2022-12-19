package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        Millenials millenials = new Millenials("Bobby07");
        YGeneration yGeneration = new YGeneration("Angel_24");
        ZGeneration zGeneration = new ZGeneration("xx_00_tr0ll");

        //When
        //Then
        assertEquals("This is Facebook Publisher", millenials.sharePost());
        assertEquals("This is Twitter Publisher", yGeneration.sharePost());
        assertEquals("This is Snapchat Publisher", zGeneration.sharePost());
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        YGeneration yGeneration = new YGeneration("Artur0");

        //When
        FacebookPublisher facebookPublisher = new FacebookPublisher();
        yGeneration.setPreferredSocialPublisher(facebookPublisher);

        //Then
        assertEquals("This is Facebook Publisher", yGeneration.sharePost());
    }
}
