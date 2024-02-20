package cz.cvut.fit.tjv.lekinohej.service;

import java.util.Collection;

import cz.cvut.fit.tjv.lekinohej.DTO.OwnerDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.request.OwnerRequestDTO;
import cz.cvut.fit.tjv.lekinohej.dao.CinemaRepository;
import cz.cvut.fit.tjv.lekinohej.dao.OwnerRepository;
import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.domain.Owner;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends AbstractCrudService<Owner,OwnerDTO, OwnerRequestDTO,Long>{
    CinemaRepository cinemaRepository;

    protected OwnerService(OwnerRepository repository, CinemaRepository cinemaRepository) {
        super(repository, Owner.class, OwnerDTO.class,OwnerRequestDTO.class);
        this.cinemaRepository = cinemaRepository;
    }

    public void addCinema(Long cinemaID, Long ownerID){
        Owner owner = repository.findById(ownerID).orElseThrow(EntityNotFoundException::new);
        owner.addCinema(cinemaRepository.findById(cinemaID).orElseThrow(EntityNotFoundException::new));
    }
    @Override
    public OwnerDTO delete(Long id) {
        Owner owner = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        Collection<Cinema> cinemasOwning = owner.getCinemasOwning();
        for(Cinema cinema : cinemasOwning){
            cinema.setOwner(null);
            cinemaRepository.save(cinema);
        }
        repository.deleteById(id);
        return modelMapper.map(owner,OwnerDTO.class);
    }
}
