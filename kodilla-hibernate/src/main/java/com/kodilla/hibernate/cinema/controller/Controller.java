package com.kodilla.hibernate.cinema.controller;

import com.kodilla.hibernate.cinema.*;
import com.kodilla.hibernate.cinema.dto.ShowDto;
import com.kodilla.hibernate.cinema.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cinema")
public class Controller {

    private DbService dbService;
    private Mapper mapper;

    public Controller(@Autowired DbService dbService, @Autowired Mapper mapper) {
        this.dbService = dbService;
        this.mapper = mapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createShow(@RequestBody ShowDto showDto) {
        //dbService.createShow(mapper.mapShowDtoToShow(showDto));
    }

    public void sellTicket(Show show, Seat seat) {

    }

    public void addMovie(Movie movie) {

    }

    public void addRoom(@RequestBody Room room) {
        dbService.createRoom(room);
    }

    public void deleteMovie(Movie movie) {

    }

    public void deleteRoom(Room room) {

    }
}
