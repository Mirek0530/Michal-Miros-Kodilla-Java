package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(432132, "mika012", 'F', LocalDate.of(1995,8,25), 54));
        forumUserList.add(new ForumUser(342516, "RobCross1", 'M', LocalDate.of(1984,4,7), 2));
        forumUserList.add(new ForumUser(788345, "John_Cherry_03", 'M', LocalDate.of(1999,12,13), 0));
        forumUserList.add(new ForumUser(157658, "ala_has_cat", 'F', LocalDate.of(2001,1,26), 320));
        forumUserList.add(new ForumUser(945623, "jonas56", 'M', LocalDate.of(2002,10,20), 59));
        forumUserList.add(new ForumUser(638986, "polishUserka", 'F', LocalDate.of(1997,5,2), 129));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }
}
