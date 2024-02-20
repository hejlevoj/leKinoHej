package cz.cvut.fit.tjv.lekinohej.service;

import cz.cvut.fit.tjv.lekinohej.dao.CinemaRepository;
import cz.cvut.fit.tjv.lekinohej.dao.OwnerRepository;
import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.domain.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CinemaServiceTest {
    @Autowired
    CinemaService cinemaService;

    @MockBean
    OwnerService ownerService;

    @MockBean
    CinemaRepository cinemaRepository;
    @Test
    public void testAssigningOwner(){
        Cinema cinema = new Cinema();
        cinema.setId(99L);
        cinema.setName("Start");
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setName("jan");
        owner.setSurname("novak");
        Mockito.when(ownerService.findByIdReturnEntity(1L)).thenReturn(owner);
        Mockito.when(cinemaRepository.findById(99L)).thenReturn(Optional.of(cinema));

        cinemaService.assignOwner(99L,1L);

        Assertions.assertEquals(owner,cinema.getOwner());
    }


}
