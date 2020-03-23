package com.example.tp.controllers;

import com.example.tp.models.Communes;
import com.example.tp.services.CommunesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/communes")
public class CommunesController {

    @Autowired
    CommunesService communesService;

    @GetMapping
    public List<Communes> getCommunes(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "limit", defaultValue = "30") int limit) {

        List<Communes> returnValue = new ArrayList<>();
        List<Communes> communes = communesService.getCommunes(page, limit);

        return communes;

    }

    @RequestMapping("/{id}")
    public Communes getCommunesById(@PathVariable Long id)
    {
        Optional<Communes> c = communesService.getCommuneById(id);
        if (c.isPresent()){
            return c.get();
        }
        throw new EntityNotFoundException("La commune d'identifiant : " +
                id + " n'a pas été trouvé.");
    }

    @RequestMapping("/insee/{code}")
    public List<Communes> getCommunesByCodeInsee(@PathVariable String code)
    {
        return (List<Communes>) communesService.getCommuneByCodeInsee(code);
    }

    @RequestMapping("/codePostal/{codePostal}")
    public List<Communes> getCommunesByCodePostal(@PathVariable String codePostal)
    {
        return communesService.getCommuneByCodePostal(codePostal);
    }

    @RequestMapping("/nom/{nom}")
    public List<Communes> getCommunesByNom(@PathVariable String nom)
    {
        return communesService.getCommuneByNom(nom);
    }

    @RequestMapping("/countInsee")
    public Long countInsee()
    {
        return communesService.countInseeCodes();
    }

    @RequestMapping("/countCodePostal")
    public Long countPostal()
    {
        return communesService.countCodesPostaux();
    }

    @PostMapping("/createCommune")
    Communes creatCommune(@RequestBody Communes newCommune) {
        return communesService.createCommune(newCommune);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Communes updateCommune(@PathVariable("id") Long id, @RequestBody Communes communes){
        return this.communesService.updateCommune(id,communes);
    }

    @DeleteMapping("/deleteCommune/{id}")
    void deleteEmployee(@PathVariable Long id) {
        communesService.deleteCommune(id);
    }
}
