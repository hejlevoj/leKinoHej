package cz.cvut.fit.tjv.lekinohej.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Min(value = 1,message = "field 'rating' must be greater or equal than 1.")
    @Max(value = 100, message = "field 'rating' must be less or equal than 100.")
    private Integer rating;

    @ManyToMany(mappedBy = "movies")
    private Set<Cinema> cinemas;

    public Movie(){

    }
    public Movie(Long id, String name, Integer rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.cinemas = new HashSet<Cinema>();
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

    public Collection<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public void addShowingAtCinema(Cinema cinema){
        this.cinemas.add(cinema);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
