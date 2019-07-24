package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User milly = new Millenials("Milly");
        User yeti = new YGeneration("Yeti");
        User zack = new ZGeneration("Zack");
        //When
        String millyPublished = milly.sharePost();
        String yetiPublished = yeti.sharePost();
        String zackPublished = zack.sharePost();
        System.out.println("Milly published post on: " + millyPublished +
                "\nYeti published post on: " + yetiPublished +
                "\nZack published post on: " + zackPublished);
        //Then
        Assert.assertEquals("Millenials not passed", "Facebook", millyPublished);
        Assert.assertEquals("YGeneration not passed", "Twitter", yetiPublished);
        Assert.assertEquals("ZGeneration not passed", "SnapChat", zackPublished);
    }


    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User milly = new Millenials("Milly");
        //When
        String millyPublished = milly.sharePost();
        System.out.println("\nMilly published post on: " + millyPublished);
        milly.setSocialPublisher(new TwitterPublisher());
        millyPublished = milly.sharePost();
        System.out.println("Milly published post on: " + millyPublished);
        //Then
        Assert.assertEquals("Twitter", millyPublished);
    }
}
