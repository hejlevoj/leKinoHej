package cz.cvut.fit.tjv.lekinohej.DTO.request;

import jakarta.validation.constraints.NotNull;

public class OwnerRequestDTO {
    @NotNull(message = "field 'name' must not be empty.")
    private String name;
    @NotNull(message = "field 'surname' must not be empty.")
    private String surname;


    public OwnerRequestDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public OwnerRequestDTO(){

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
}
