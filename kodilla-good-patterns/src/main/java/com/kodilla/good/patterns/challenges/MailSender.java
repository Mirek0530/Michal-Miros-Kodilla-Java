package com.kodilla.good.patterns.challenges;

public class MailSender implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Send e-mail to: " + user.getEmailAddress());
    }
}
