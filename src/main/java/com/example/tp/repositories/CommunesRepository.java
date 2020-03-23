package com.example.tp.repositories;

import com.example.tp.models.Communes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunesRepository extends JpaRepository<Communes, Long> {

    List<Communes> findByCodeCommuneInsee(String code);

    List<Communes> findByCodePostal(String codePostal);

    List<Communes> findByNomCommuneContaining(String nom);

    @Query("select DISTINCT count(code_commune_INSEE) from Communes c")
    Long findCountInseeCode();

    @Query("select DISTINCT count(code_postal) from Communes c")
    Long findCountCodePostal();


}
