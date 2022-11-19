package com.example.gestion_cinema_naour_boutaina.mappers;

import com.example.gestion_cinema_naour_boutaina.DTOS.CinemaDtos;
import com.example.gestion_cinema_naour_boutaina.entities.Cinema;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CinemaMapperImpl {
    public CinemaDtos fromCinema(Cinema cinema){
        CinemaDtos cinemaDtos=new CinemaDtos();
        BeanUtils.copyProperties(cinema,cinemaDtos);
        return  cinemaDtos;
    }
    public Cinema fromCinemaDtos(CinemaDtos cinemaDtos){
        Cinema cinema=new Cinema();
        BeanUtils.copyProperties(cinemaDtos,cinema);
        return  cinema;
    }
}
