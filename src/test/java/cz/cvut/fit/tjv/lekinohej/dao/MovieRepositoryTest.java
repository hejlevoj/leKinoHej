package cz.cvut.fit.tjv.lekinohej.dao;

import cz.cvut.fit.tjv.lekinohej.domain.Movie;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void ConstraintsViolationTest(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Movie movie1 = new Movie();
        movie1.setRating(666); //rating higher than 100
        Set<ConstraintViolation<Movie>> violations1 = validator.validate(movie1);
        Movie movie2 = new Movie();
        movie2.setRating(0);
        Set<ConstraintViolation<Movie>> violations2 = validator.validate(movie1);
        assertEquals(1,violations1.size());
        assertEquals(1,violations2.size());
    }

    @Test
    public void ListMoviesNotInAnyCinemasTest(){
        Movie movie = new Movie(1L,"godfather",20);
        movieRepository.save(movie);
        Assertions.assertEquals(1,movieRepository.moviesNotInAnyCinema().size());
    }

}
