package cz.cvut.fit.tjv.lekinohej.DTO.nested;

public class MovieSimpleDTO {
    private Long id;

    private String name;

    private Integer rating;

    public MovieSimpleDTO(Long id, String name, Integer rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public MovieSimpleDTO(){

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
}
