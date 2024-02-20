package cz.cvut.fit.tjv.lekinohej.service;

import cz.cvut.fit.tjv.lekinohej.DTO.CinemaDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.request.CinemaRequestDTO;
import cz.cvut.fit.tjv.lekinohej.dao.CinemaRepository;
import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.domain.Movie;
import cz.cvut.fit.tjv.lekinohej.domain.Owner;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaService extends AbstractCrudService<Cinema, CinemaDTO, CinemaRequestDTO, Long>{
    private OwnerService ownerService;
    private MovieService movieService;

    protected CinemaService(CinemaRepository repository, OwnerService ownerService, MovieService movieService) {
        super(repository, Cinema.class, CinemaDTO.class, CinemaRequestDTO.class);
        this.ownerService = ownerService;
        this.movieService = movieService;
    }
    @Transactional
    public void assignOwner(Long cinemadID, Long ownerId){
        Owner owner = ownerService.findByIdReturnEntity(ownerId);
        Cinema cinema = repository.findById(cinemadID).orElseThrow(EntityNotFoundException::new);
        cinema.setOwner(owner);
    }

    @Transactional
    public void addMovie(Long cinemaID,Long movieID){
        Movie movie = movieService.findByIdReturnEntity(movieID);
        Cinema cinema = repository.findById(cinemaID).orElseThrow(EntityNotFoundException::new);
        cinema.addMovie(movie);
    }

    @Transactional
    public void removeMovie(Long cinemaID, Long movieID){
        Movie movie = movieService.findByIdReturnEntity(movieID);
        Cinema cinema = repository.findById(cinemaID).orElseThrow(EntityNotFoundException::new);
        cinema.removeMovie(movie);
    }
}
