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
    public Cinema updateCinema(Cinema cinemaDtos,Long id ) {
        log.info("Updating  SALLE DE CINEMA");

        Cinema dep=cinemaRepo.findById(id).orElse(null);

        dep.setNom(cinemaDtos.getNom());
        dep.setAdresse(cinemaDtos.getAdresse());
        dep.setDate_creation(cinemaDtos.getDate_creation());
        dep.setNbr_chaise(cinemaDtos.getNbr_chaise());
        dep.setStatut(cinemaDtos.getStatut());
        dep.setType(cinemaDtos.getType());

        Cinema savedEvent = cinemaRepo.save(dep);
        return savedEvent;
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

        List<Cinema> cinemas=cinemaRepo.findByStatut(statut);
        List<CinemaDtos> cinemaDtos = cinemas.stream()
                .map(cine -> dtoMapper.fromCinema(cine)).collect(Collectors.toList());
        return cinemaDtos;
    }

    @Override
    public List<CinemaDtos> searchParType(TypeFilm typeFilm) {
        List<Cinema> cinemas=cinemaRepo.findByType(typeFilm);
        List<CinemaDtos> cinemaDtos = cinemas.stream()
                .map(cine -> dtoMapper.fromCinema(cine)).collect(Collectors.toList());
        return cinemaDtos;
    }

    @Override
    public CinemaDtos searchParId(Long id) {

        Cinema cinema = cinemaRepo.findById(id).orElse(null);
        CinemaDtos cinemaDtos = dtoMapper.fromCinema(cinema);
        return  cinemaDtos;
    }
}
