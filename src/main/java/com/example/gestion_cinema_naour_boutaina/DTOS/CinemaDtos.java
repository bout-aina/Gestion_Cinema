package com.example.gestion_cinema_naour_boutaina.DTOS;

import com.example.gestion_cinema_naour_boutaina.enums.Statut;
import com.example.gestion_cinema_naour_boutaina.enums.TypeFilm;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Data
public class CinemaDtos {
    private Long id;
    private String nom ;
    private String adresse;
    private Date date_creation;
    private int nbr_chaise;
    private Statut statut;
    private TypeFilm type;
}
