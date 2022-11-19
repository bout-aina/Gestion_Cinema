package com.example.gestion_cinema_naour_boutaina;

import com.example.gestion_cinema_naour_boutaina.entities.Cinema;
import com.example.gestion_cinema_naour_boutaina.enums.Statut;
import com.example.gestion_cinema_naour_boutaina.enums.TypeFilm;
import com.example.gestion_cinema_naour_boutaina.repositories.CinemaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionCinemaNaourBoutainaApplication implements CommandLineRunner {
    @Autowired
    CinemaRepo cinemaRepo;
    public static void main(String[] args) {
        SpringApplication.run(GestionCinemaNaourBoutainaApplication.class, args);




    }
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 11; i++) {
            cinemaRepo.save(new Cinema(null,"Salle_"+i,"ADRESSE_"+i,new Date(),
                    i,
                    (i%2==0)? Statut.OUVERTE : Statut.FERMEE,
                    (i%2==0)? TypeFilm.STANDARD : TypeFilm.VR  ));
        }
    }

}
