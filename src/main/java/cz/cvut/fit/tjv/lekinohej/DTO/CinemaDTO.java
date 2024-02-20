package cz.cvut.fit.tjv.lekinohej.DTO;

import cz.cvut.fit.tjv.lekinohej.DTO.nested.MovieSimpleDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.nested.OwnerSimpleDTO;

import java.util.*;

public class CinemaDTO {
    private Long id;

    private String name;

    private Integer numberOfSeats;

    private OwnerSimpleDTO owner;

    private Collection<MovieSimpleDTO> movies;

    public CinemaDTO(Long id, String name, Integer numberOfSeats, OwnerSimpleDTO owner) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.owner = owner;
        this.movies = new HashSet<>();
    }

    public CinemaDTO(){

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

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public OwnerSimpleDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerSimpleDTO owner) {
        this.owner = owner;
    }

    public Collection<MovieSimpleDTO> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieSimpleDTO> movies) {
        this.movies = movies;
    }
}
