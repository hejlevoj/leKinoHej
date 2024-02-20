package cz.cvut.fit.tjv.lekinohej.dao;

import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {

    //komplexni dotaz: filmy ktere nejsou promitany v zadnem kine
    @Query("select m from Movie m left join m.cinemas c where c.id is null")
    Collection<Movie>moviesNotInAnyCinema();

    Optional<Movie> findMovieByName(String name);
}
