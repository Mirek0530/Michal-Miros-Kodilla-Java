package com.kodilla.hibernate.cinema.dao;

import com.kodilla.hibernate.cinema.Movie;
import com.kodilla.hibernate.cinema.Room;
import com.kodilla.hibernate.cinema.Show;
import com.kodilla.hibernate.cinema.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CinemaDaoTestSuite {

    @Autowired
    private CinemaDao cinemaDao;

    @Test
    void testCinemaDao() {
        //Given
        Movie avatar = new Movie("Avatar 2", 193);
        Movie fantasticBeasts = new Movie("Fantastic Beasts", 142);
        Movie dune = new Movie("Dune", 155);
        Movie eternals = new Movie("Eternals", 156);

        Show show1 = new Show(avatar, LocalDateTime.of(2023,1,25,15,15));
        Show show2 = new Show(fantasticBeasts, LocalDateTime.of(2022,12,23,19,20));
        Show show3 = new Show(dune, LocalDateTime.of(2021,11,3,12,5));
        Show show4 = new Show(eternals, LocalDateTime.of(2021,11,7,22,0));

        Room room1 = new Room(350);
        Room room2 = new Room(400);

        room1.getShows().add(show1);
        room1.getShows().add(show2);
        room1.getShows().add(show3);
        room2.getShows().add(show4);

        show1.setRoom(room1);
        show2.setRoom(room1);
        show3.setRoom(room1);
        show4.setRoom(room2);

        for (int i = 0; i <= 300; i++) {
            show1.getTickets().add(new Ticket(i + 1, new BigDecimal(20)));
            show2.getTickets().add(new Ticket(i + 1, new BigDecimal(25)));
            show3.getTickets().add(new Ticket(i + 1, new BigDecimal(23)));
            show4.getTickets().add(new Ticket(i + 1, new BigDecimal(18)));
        }

        //When
        cinemaDao.save(room1);
        int room1Id = room1.getId();
        cinemaDao.save(room2);
        int room2Id = room2.getId();

        //Then
        assertNotEquals(0, room1Id);
        assertNotEquals(0, room2Id);

        //CleanUp
        //cinemaDao.deleteAll();
    }
}
