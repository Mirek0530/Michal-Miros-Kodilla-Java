package com.kodilla.hibernate.cinema.dao;

import com.kodilla.hibernate.cinema.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface CinemaDao extends CrudRepository<Room, Integer> {
}
