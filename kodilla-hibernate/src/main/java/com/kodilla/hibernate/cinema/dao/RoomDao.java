package com.kodilla.hibernate.cinema.dao;

import com.kodilla.hibernate.cinema.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface RoomDao extends CrudRepository<Room, Integer> {
}
