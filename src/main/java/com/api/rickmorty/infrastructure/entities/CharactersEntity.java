package com.api.rickmorty.infrastructure.entities;

import com.api.rickmorty.domain.model.Characters;
import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class CharactersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Integer location_id;

    public CharactersEntity() {
    }

    public CharactersEntity(Integer id, String name, String status, String species, String type, String gender, Integer location_id) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.location_id = location_id;
    }

   public static CharactersEntity fromDomainModel(Characters characters){
        return new CharactersEntity(characters.getId(), characters.getName(), characters.getStatus(), characters.getSpecies(), characters.getType(), characters.getGender(), characters.getLocation_id());
    }

    public Characters toDomainModel(){
        return new Characters(id, name, status, species, type, gender, location_id);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

}
