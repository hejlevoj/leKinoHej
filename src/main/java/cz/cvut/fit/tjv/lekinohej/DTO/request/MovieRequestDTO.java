package cz.cvut.fit.tjv.lekinohej.DTO.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MovieRequestDTO {
    @NotNull(message = "field 'name' must not be empty.")
    private String name;

    @Min(value = 1,message = "field 'rating' must be greater or equal than 1.")
    @Max(value = 100, message = "field 'rating' must be less or equal than 100.")
    private Integer rating;

    public MovieRequestDTO(String name, Integer rating) {
        this.name = name;
        this.rating = rating;
    }

    public MovieRequestDTO(){

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
}
