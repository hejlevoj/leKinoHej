package cz.cvut.fit.tjv.lekinohej.api.controller;

import cz.cvut.fit.tjv.lekinohej.DTO.CinemaDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.request.CinemaRequestDTO;
import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.service.CinemaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController extends AbstractRestController<Cinema, CinemaDTO, CinemaRequestDTO,Long>{
    private final CinemaService cinemaService;

    public CinemaController(CinemaService service) {
        super(service);
        cinemaService = service;
    }
    @PostMapping("{cinemaID}/assignOwner/{ownerID}")
    public void assignOwner(@PathVariable Long cinemaID, @PathVariable Long ownerID){
        cinemaService.assignOwner(cinemaID,ownerID);
    }

    @PostMapping("{cinemaID}/addMovie/{movieID}")
    public void addMovie(@PathVariable Long cinemaID, @PathVariable Long movieID){
        cinemaService.addMovie(cinemaID,movieID);
    }
    @PostMapping("{cinemaID}/removeMovie/{movieID}")
    public void removeMovie(@PathVariable Long cinemaID, @PathVariable Long movieID){
        cinemaService.removeMovie(cinemaID,movieID);
    }

}
