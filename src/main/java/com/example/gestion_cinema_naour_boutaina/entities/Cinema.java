package com.example.gestion_cinema_naour_boutaina.entities;

import com.example.gestion_cinema_naour_boutaina.enums.Statut;
import com.example.gestion_cinema_naour_boutaina.enums.TypeFilm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50,nullable = false)
    private String nom ;
    private String adresse;
    @Temporal(TemporalType.DATE) // pour specifier que la saisie de ladate sans heure
    @Column(nullable = false)
    private Date date_creation;
    private int nbr_chaise;
    @Column(nullable = false)
    private Statut statut;
    @Column(nullable = false)
    private TypeFilm type;
}
