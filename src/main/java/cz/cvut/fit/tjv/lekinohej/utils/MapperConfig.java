package cz.cvut.fit.tjv.lekinohej.utils;

import cz.cvut.fit.tjv.lekinohej.DTO.CinemaDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.MovieDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.nested.CinemaSimpleDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.nested.MovieSimpleDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.nested.OwnerSimpleDTO;
import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.domain.Movie;
import cz.cvut.fit.tjv.lekinohej.domain.Owner;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);

        //DTO
        TypeMap<Cinema, CinemaDTO> cinemaToCinemaDTOTypeMap = mapper.createTypeMap(Cinema.class, CinemaDTO.class);
        TypeMap<Movie, MovieDTO> movieToMovieDTOTypeMap = mapper.createTypeMap(Movie.class,MovieDTO.class);


        //nested DTO
        TypeMap<Owner, OwnerSimpleDTO> ownerToOwnerNestedDTOTypeMap = mapper.createTypeMap(Owner.class, OwnerSimpleDTO.class);
        TypeMap<Movie, MovieSimpleDTO> movieToMovieNestedDTOTypeMap = mapper.createTypeMap(Movie.class, MovieSimpleDTO.class);
        TypeMap<Cinema, CinemaSimpleDTO> cinemaToCinemaNestedDTOTypeMap = mapper.createTypeMap(Cinema.class, CinemaSimpleDTO.class);

        // Define custom mappings for Cinema to CinemaDTO
        cinemaToCinemaDTOTypeMap.addMapping(src -> src.getId(), CinemaDTO::setId);
        cinemaToCinemaDTOTypeMap.addMapping(src -> src.getName(), CinemaDTO::setName);
            // Define custom mappings for the movies collection
        cinemaToCinemaDTOTypeMap.addMapping(src -> src.getMovies(), CinemaDTO::setMovies);
            // Mapping for Cinema to CinemaSimpleDTO
        cinemaToCinemaNestedDTOTypeMap.addMapping(src -> src.getId(), CinemaSimpleDTO::setId);
        cinemaToCinemaNestedDTOTypeMap.addMapping(src -> src.getName(), CinemaSimpleDTO::setName);


        // Define custom mapping for Owner to OwnerSimpleDTO
        ownerToOwnerNestedDTOTypeMap.addMapping(src -> src.getId(), OwnerSimpleDTO::setId);
        ownerToOwnerNestedDTOTypeMap.addMapping(src -> src.getName(), OwnerSimpleDTO::setName);
        ownerToOwnerNestedDTOTypeMap.addMapping(src -> src.getSurname(), OwnerSimpleDTO::setSurname);



        //Mapping for Movie to MovieDTO
        movieToMovieDTOTypeMap.addMapping(src-> src.getId(),MovieDTO::setId);
        movieToMovieDTOTypeMap.addMapping(src-> src.getName(),MovieDTO::setName);
        movieToMovieDTOTypeMap.addMapping(src-> src.getRating(),MovieDTO::setRating);
        movieToMovieDTOTypeMap.addMapping(src -> src.getCinemas(),MovieDTO::setCinemasShowingThisMovie);
            // Define custom mappings for Movie to MovieSimpleDTO
        movieToMovieNestedDTOTypeMap.addMapping(src -> src.getId(), MovieSimpleDTO::setId);
        movieToMovieNestedDTOTypeMap.addMapping(src -> src.getName(), MovieSimpleDTO::setName);
        return mapper;
    }
}
