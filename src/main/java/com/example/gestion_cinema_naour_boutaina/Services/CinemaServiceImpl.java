package com.example.gestion_cinema_naour_boutaina.Services;

import com.example.gestion_cinema_naour_boutaina.DTOS.CinemaDtos;
import com.example.gestion_cinema_naour_boutaina.entities.Cinema;
import com.example.gestion_cinema_naour_boutaina.enums.Statut;
import com.example.gestion_cinema_naour_boutaina.enums.TypeFilm;
import com.example.gestion_cinema_naour_boutaina.mappers.CinemaMapperImpl;
import com.example.gestion_cinema_naour_boutaina.repositories.CinemaRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CinemaServiceImpl implements CinemaService {
    private CinemaRepo cinemaRepo;
    private CinemaMapperImpl dtoMapper;
    @Override
    public CinemaDtos saveCinema(CinemaDtos cinemaDtos) {
        log.info("Saving new SALLE DE CINEMA");
        Cinema cinema=dtoMapper.fromCinemaDtos(cinemaDtos);
        Cinema savedCinema=cinemaRepo.save(cinema);
        return dtoMapper.fromCinema(savedCinema);
    }



    @Override
    public List<CinemaDtos> listCinema() {
        List<Cinema> cinemas = cinemaRepo.findAll();
        List<CinemaDtos> cinemaDtos= cinemas.stream()
                .map(cinema -> dtoMapper.fromCinema(cinema))
                .collect(Collectors.toList());
        return cinemaDtos;
    }

    @Override
    public void deleteCinema(Long idSalle) {
       cinemaRepo.deleteById(idSalle);
    }

    @Override
    public CinemaDtos updateCinema(CinemaDtos cinemaDtos, Long id) {
        return null;
    }

    @Override
    public List<CinemaDtos> searchParNomsalle(String nom) {
        List<Cinema> cinemas=cinemaRepo.searchbyName(nom);
        List<CinemaDtos> cinemaDtos = cinemas.stream()
                .map(cine -> dtoMapper.fromCinema(cine)).collect(Collectors.toList());
        return cinemaDtos;
    }

    @Override
    public List<CinemaDtos> searchParStatus(Statut statut) {
        return null;
    }

    @Override
    public List<CinemaDtos> searchParType(TypeFilm typeFilm) {
        return null;
    }

    @Override
    public Cinema searchParId(Long id) {
        return null;
    }
}
