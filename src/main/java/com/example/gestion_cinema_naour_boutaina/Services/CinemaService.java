package com.example.gestion_cinema_naour_boutaina.Services;

import com.example.gestion_cinema_naour_boutaina.DTOS.CinemaDtos;
import com.example.gestion_cinema_naour_boutaina.entities.Cinema;
import com.example.gestion_cinema_naour_boutaina.enums.Statut;
import com.example.gestion_cinema_naour_boutaina.enums.TypeFilm;

import java.util.List;

public interface CinemaService {
    CinemaDtos saveCinema(CinemaDtos cinemaDtos);
    List<CinemaDtos> listCinema();
    void deleteCinema(Long idSalle);
    CinemaDtos updateCinema(CinemaDtos cinemaDtos,Long id);

    List<CinemaDtos> searchParNomsalle(String nom);
    List<CinemaDtos> searchParStatus(Statut statut);
    List<CinemaDtos> searchParType(TypeFilm typeFilm);
    Cinema searchParId(Long id);




}
