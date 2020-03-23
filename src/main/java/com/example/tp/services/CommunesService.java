package com.example.tp.services;

import com.example.tp.models.Communes;
import com.example.tp.models.Communes;
import com.example.tp.repositories.CommunesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommunesService {
    @Autowired
    private CommunesRepository communesRepository;

    public List<Communes> getCommunes(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<Communes> communes = communesRepository.findAll(pageableRequest);
        List<Communes> communesEntities = communes.getContent();

        return communesEntities;
    }

    public Optional<Communes> getCommuneById(Long id)
    {
        return communesRepository.findById(id);
        //TODO THROW EXCEPTION
    }

    public List<Communes> getCommuneByCodeInsee(String code)
    {
        return communesRepository.findByCodeCommuneInsee(code);
        //TODO THROW EXCEPTION
    }

    public List<Communes> getCommuneByCodePostal(String code)
    {
        return communesRepository.findByCodePostal(code);
        //TODO THROW EXCEPTION
    }

    public List<Communes> getCommuneByNom(String nom)
    {
        return communesRepository.findByNomCommuneContaining(nom);
    }

    public Long countInseeCodes()
    {
        return communesRepository.findCountInseeCode();
    }

    public Long countCodesPostaux()
    {
        return communesRepository.findCountCodePostal();
    }

    public Communes createCommune(Communes newCommune){
        List<Communes> codesInsee = communesRepository.findByCodeCommuneInsee(newCommune.getCodeCommuneInsee());
        if (codesInsee != null){
           for (Integer i = 0; i < codesInsee.size(); i++){

           }
        }
        return communesRepository.save(newCommune);
    }

    public <T extends Communes> T updateCommune(Long id, T commune) {
        if(!communesRepository.existsById(id)) {
            throw new EntityNotFoundException("La commune d'identifiant " + id + " n'existe pas !");
        }
        return communesRepository.save(commune);
    }

    public void deleteCommune(Long id) {
        if (!communesRepository.existsById(id)){
            throw new EntityNotFoundException("La commune d'identifiant " + id + " n'existe pas !");
        }
            communesRepository.deleteById(id);
        }
}
