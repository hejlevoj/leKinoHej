package cz.cvut.fit.tjv.lekinohej.DTO;


import cz.cvut.fit.tjv.lekinohej.DTO.nested.CinemaSimpleDTO;

import java.util.Collection;
import java.util.HashSet;

public class OwnerDTO{
    private Long id;

    private String name;

    private String surname;
    private Integer age;

    private Collection<CinemaSimpleDTO> cinemasOwning;

    public OwnerDTO(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cinemasOwning = new HashSet<>();
    }

    public OwnerDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Collection<CinemaSimpleDTO> getCinemasOwning() {
        return cinemasOwning;
    }

    public void setCinemasOwning(Collection<CinemaSimpleDTO> cinemasOwning) {
        this.cinemasOwning = cinemasOwning;
    }
}
