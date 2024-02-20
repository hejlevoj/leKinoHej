package cz.cvut.fit.tjv.lekinohej.DTO.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CinemaRequestDTO {
    @NotNull(message = "field 'name' must not be empty.")
    private String name;

    @Min(value = 1,message = "field 'numberOfSeats' must be greater or equal to 1.")
    @Max(value = 999, message = "field 'numberOfSeats' must be less or equal than 999.")
    private Integer numberOfSeats;

    public CinemaRequestDTO(String name, Integer numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public CinemaRequestDTO(){

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
}
