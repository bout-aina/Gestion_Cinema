package com.example.gestion_cinema_naour_boutaina.controllers;

import com.example.gestion_cinema_naour_boutaina.DTOS.CinemaDtos;
import com.example.gestion_cinema_naour_boutaina.Services.CinemaService;
import com.example.gestion_cinema_naour_boutaina.entities.Cinema;
import com.example.gestion_cinema_naour_boutaina.enums.Statut;
import com.example.gestion_cinema_naour_boutaina.enums.TypeFilm;
import com.example.gestion_cinema_naour_boutaina.repositories.CinemaRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor

@RequestMapping(produces = "application/json" , path = "monapi")
public class CinemaRestController {
    private CinemaService cinemaService;
    @GetMapping("/Salles")
    public List<CinemaDtos> Salles(){
        return cinemaService.listCinema();

    }
    @PostMapping("/saveSalle")
    public CinemaDtos saveSalle(@RequestBody CinemaDtos cinemaDtos)
    {
        return  cinemaService.saveCinema(cinemaDtos);
    }
    @DeleteMapping("/Salle/{id}")
    public void deleteSalle(@PathVariable Long id){

        cinemaService.deleteCinema(id);
    }
    @PutMapping("/Salleupdate/{id}")
    public Cinema updateCinema(@RequestBody Cinema cinemaDtos,@PathVariable Long id )
    {
       return  cinemaService.updateCinema(cinemaDtos,id);
    }

    @GetMapping("/Salles/searchByName")
    public List<CinemaDtos> searchbyname(@RequestParam(name ="keyword",defaultValue = "") String keyword){
        return cinemaService.searchParNomsalle("%"+keyword+"%");
    }
    @GetMapping("/Salles/searchByStatus")
    public List<CinemaDtos> searchBystatus(@RequestParam(name ="keyword",defaultValue = "") Statut keyword){
        return cinemaService.searchParStatus(keyword);
    }
    @GetMapping("/Salles/searchByType")
    public List<CinemaDtos> searchBytype(@RequestParam(name ="keyword",defaultValue = "") TypeFilm keyword){
        return cinemaService.searchParType(keyword);
    }
    @GetMapping("/Salles/searchById")
    public CinemaDtos searchParId( Long id){
        return cinemaService.searchParId(id);
    }


}
