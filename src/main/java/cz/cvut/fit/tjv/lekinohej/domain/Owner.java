package cz.cvut.fit.tjv.lekinohej.domain;

import cz.cvut.fit.tjv.lekinohej.DTO.OwnerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Owner implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    private Integer age;

    @OneToMany(mappedBy = "owner")
    private Set<Cinema> cinemasOwning;

    public Owner(){

    }
    public Owner(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cinemasOwning = new HashSet<Cinema>();
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

    public Collection<Cinema> getCinemasOwning() {
        return cinemasOwning;
    }

    public void setCinemasOwning(Set<Cinema> cinemasOwning) {
        this.cinemasOwning = cinemasOwning;
    }

    public void addCinema(Cinema cinema){
        this.cinemasOwning.add(cinema);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
