package com.kodilla.hibernate.cinema.dao;

import com.kodilla.hibernate.cinema.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MovieDao extends CrudRepository<Movie, Integer> {
}
