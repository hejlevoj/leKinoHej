package cz.cvut.fit.tjv.lekinohej.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cinema implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Min(value = 1,message = "field 'numberOfSeats' must be greater or equal to 1.")
    @Max(value = 999, message = "field 'numberOfSeats' must be less or equal than 999.")
    private Integer numberOfSeats;

    @ManyToMany
    private Set<Movie> movies;

    @ManyToOne
    private Owner owner;

    public Cinema() {
    }

    public Cinema(Long id, String name, Integer numberOfSeats, Owner owner) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.owner = owner;

        this.movies = new HashSet<Movie>();
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

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void removeMovie(Movie movie){this.movies.remove(movie);}

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(id, cinema.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
