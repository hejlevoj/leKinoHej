package cz.cvut.fit.tjv.lekinohej.controller;

import cz.cvut.fit.tjv.lekinohej.api.controller.CinemaController;
import cz.cvut.fit.tjv.lekinohej.domain.Cinema;
import cz.cvut.fit.tjv.lekinohej.domain.Movie;
import cz.cvut.fit.tjv.lekinohej.domain.Owner;
import cz.cvut.fit.tjv.lekinohej.service.CinemaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CinemaController.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CinemaControllerTest {
    @MockBean
    private CinemaService cinemaService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        Cinema cinema = new Cinema();
        cinema.setId(1L);

        Movie movie = new Movie();
        movie.setId(1L);

        Owner owner = new Owner();
        owner.setId(1L);

        when(cinemaService.findByIdReturnEntity(anyLong())).thenReturn(cinema);
        doNothing().when(cinemaService).assignOwner(anyLong(), anyLong());
        doNothing().when(cinemaService).addMovie(anyLong(), anyLong());
        doNothing().when(cinemaService).removeMovie(anyLong(), anyLong());
    }
    @Test
    public void assignOwnerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cinema/{cinemaID}/assignOwner/{ownerID}", 1L, 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void addMovieTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cinema/{cinemaID}/addMovie/{movieID}", 1L, 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void removeMovieTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cinema/{cinemaID}/removeMovie/{movieID}", 1L, 1L))
                .andExpect(status().isOk());
    }

}
