package cz.cvut.fit.tjv.lekinohej.DTO.nested;

public class CinemaSimpleDTO {
    private Long id;

    private String name;

    private Integer numberOfSeats;

    public CinemaSimpleDTO(Long id, String name, Integer numberOfSeats) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public CinemaSimpleDTO(){

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
}
