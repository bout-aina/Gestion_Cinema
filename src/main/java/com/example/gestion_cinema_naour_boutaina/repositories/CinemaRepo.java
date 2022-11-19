package com.example.gestion_cinema_naour_boutaina.repositories;

import ch.qos.logback.core.status.Status;
import com.example.gestion_cinema_naour_boutaina.entities.Cinema;
import com.example.gestion_cinema_naour_boutaina.enums.Statut;
import com.example.gestion_cinema_naour_boutaina.enums.TypeFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface CinemaRepo extends JpaRepository<Cinema,Long> {
    @Query("select c from Cinema c where c.nom like :kw")
    List<Cinema> searchbyName(@Param("kw") String keyword);

    //List<Cinema> findByStatut(Statut status);
    //List<Cinema> findByTypeFilm(TypeFilm typeFilm);


}
