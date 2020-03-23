package com.example.tp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "communes")
public class Communes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code_commune_INSEE")
    private String codeCommuneInsee;

    @Column(name="nom_commune")
    private String nomCommune;

    @Column(name="code_postal")
    private String codePostal;

    @Column(name="libelle_acheminement")
    private String libelleAcheminement;

    @Column(name="ligne_5")
    private String ligne5;

    private String latitude;

    private String longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCommuneInsee() {
        return codeCommuneInsee;
    }

    public void setCodeCommuneInsee(String codeCommuneInsee) {
        this.codeCommuneInsee = codeCommuneInsee;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }

    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }

    public String getLigne5() {
        return ligne5;
    }

    public void setLigne5(String ligne5) {
        this.ligne5 = ligne5;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}