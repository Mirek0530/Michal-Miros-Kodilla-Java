package com.kodilla.hibernate.cinema.service;

import com.kodilla.hibernate.cinema.Room;
import com.kodilla.hibernate.cinema.Show;
import com.kodilla.hibernate.cinema.dao.MovieDao;
import com.kodilla.hibernate.cinema.dao.RoomDao;
import com.kodilla.hibernate.cinema.dao.ShowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DbService {

    private final ShowDao showDao;
    private final RoomDao roomDao;
    private final MovieDao movieDao;

    public DbService(@Autowired ShowDao showDao, @Autowired RoomDao roomDao, @Autowired MovieDao movieDao) {
        this.showDao = showDao;
        this.roomDao = roomDao;
        this.movieDao = movieDao;
    }

    public void createShow(Show show) {
        showDao.save(show);
    }

    public void createRoom(Room room) {
        roomDao.save(room);
    }
}
