package cz.cvut.fit.tjv.lekinohej.service;

import cz.cvut.fit.tjv.lekinohej.DTO.MovieDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.request.MovieRequestDTO;
import cz.cvut.fit.tjv.lekinohej.dao.CinemaRepository;
import cz.cvut.fit.tjv.lekinohej.dao.MovieRepository;
import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.domain.Movie;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService extends AbstractCrudService<Movie, MovieDTO, MovieRequestDTO,Long>{
    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;

    protected MovieService(MovieRepository repository, CinemaRepository cinemaRepository) {
        super(repository, Movie.class, MovieDTO.class, MovieRequestDTO.class);
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = repository;
    }

    @Override
    public MovieDTO create(MovieRequestDTO movieDTO) {
       return super.create(movieDTO);
    }

    @Override
    public MovieDTO delete(Long id) {
        Movie movie = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        Collection<Cinema> cinemaCollection = movie.getCinemas();
        for(Cinema cinema: cinemaCollection){
            cinema.getMovies().remove(movie);
        }
        repository.deleteById(id);
        return modelMapper.map(movie,MovieDTO.class);
    }

    public List<MovieDTO> moviesNotDisplayedInAnyCinema(){
        return movieRepository.moviesNotInAnyCinema()
                .stream()
                .map((movie) -> modelMapper.map(movie,MovieDTO.class))
                .toList();
    }

    public Optional<MovieDTO> findMovieByName(String name){
        Optional<Movie> movie = movieRepository.findMovieByName(name);
        if(movie.isPresent()){
            return Optional.of(modelMapper.map(movie.get(),MovieDTO.class));
        }
        return Optional.empty();
    }
}
