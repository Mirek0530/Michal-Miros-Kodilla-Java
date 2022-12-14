package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().isBefore(LocalDate.now().minusYears(20).plusDays(1)))
                .filter(forumUser -> forumUser.getPostsCounter() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        resultMap.entrySet().stream()
                .forEach(System.out::println);
    }
}
