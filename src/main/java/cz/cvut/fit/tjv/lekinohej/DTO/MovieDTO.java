package cz.cvut.fit.tjv.lekinohej.DTO;

import cz.cvut.fit.tjv.lekinohej.DTO.nested.CinemaSimpleDTO;

import java.util.Collection;
import java.util.HashSet;

public class MovieDTO {
    private Long id;

    private String name;

    private Integer rating;

    private Collection<CinemaSimpleDTO> cinemasShowingThisMovie;

    public MovieDTO(Long id, String name, Integer rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.cinemasShowingThisMovie = new HashSet<>();
    }

    public MovieDTO(){

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Collection<CinemaSimpleDTO> getCinemasShowingThisMovie() {
        return cinemasShowingThisMovie;
    }

    public void setCinemasShowingThisMovie(Collection<CinemaSimpleDTO> cinemasShowingThisMovie) {
        this.cinemasShowingThisMovie = cinemasShowingThisMovie;
    }
}
