package cz.cvut.fit.tjv.lekinohej.api.controller;

import cz.cvut.fit.tjv.lekinohej.DTO.MovieDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.request.MovieRequestDTO;
import cz.cvut.fit.tjv.lekinohej.domain.Movie;
import cz.cvut.fit.tjv.lekinohej.service.MovieService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController extends AbstractRestController<Movie, MovieDTO, MovieRequestDTO,Long>{
    private MovieService movieService;
    public MovieController(MovieService service) {
        super(service);
        this.movieService = service;
    }

    @Override
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "409", content = @Content, description = "Movie with the same name already exists")

            })
    public ResponseEntity<MovieDTO> create(@Valid @RequestBody MovieRequestDTO entity) {
        Optional<MovieDTO> movie = movieService.findMovieByName(entity.getName());
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.CONFLICT);
        }
        return super.create(entity);
    }

    @GetMapping("/notShownAnywhere")
    public List<MovieDTO> getMoviesNotInAnyCinema(){
        return movieService.moviesNotDisplayedInAnyCinema();
    }
}
