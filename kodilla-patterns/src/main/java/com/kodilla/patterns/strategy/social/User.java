package com.kodilla.patterns.strategy.social;

public sealed class User
        permits Millenials, YGeneration, ZGeneration {

    protected String username;
    protected SocialPublisher socialPublisher;

    public User(String username) {
        this.username = username;
    }

    public String sharePost() {
        return this.socialPublisher.share();
    }

    public void setPreferredSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }


}
