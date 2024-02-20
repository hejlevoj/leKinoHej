package cz.cvut.fit.tjv.lekinohej.dao;

import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema,Long> {
    @Query("SELECT c FROM Cinema c JOIN c.movies m WHERE m.name = :movieName")
    Collection<Cinema> findCinemasByMovieName(@Param("movieName") String movieName);

}
