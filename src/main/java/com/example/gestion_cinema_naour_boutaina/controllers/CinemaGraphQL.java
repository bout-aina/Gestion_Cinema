package com.example.gestion_cinema_naour_boutaina.controllers;

import com.example.gestion_cinema_naour_boutaina.DTOS.CinemaDtos;
import com.example.gestion_cinema_naour_boutaina.Services.CinemaService;
import com.example.gestion_cinema_naour_boutaina.entities.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CinemaGraphQL {
    @Autowired
    CinemaService cinemaService;
    @QueryMapping
    public List<CinemaDtos> getcinemas()
    {
        return  cinemaService.listCinema();
    }
}
