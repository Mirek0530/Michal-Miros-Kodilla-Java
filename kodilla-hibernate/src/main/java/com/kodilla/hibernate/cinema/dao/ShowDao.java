package com.kodilla.hibernate.cinema.dao;

import com.kodilla.hibernate.cinema.Show;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ShowDao extends CrudRepository<Show, Integer> {

}
