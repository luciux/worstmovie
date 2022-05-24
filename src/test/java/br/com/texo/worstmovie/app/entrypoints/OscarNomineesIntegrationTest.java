package br.com.texo.worstmovie.app.entrypoints;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import br.com.texo.worstmovie.domain.movielist.entities.MovieResultDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class OscarNomineesIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("return the film list when sucessful")
    void shouldReturnTheFilmListWhenSucessful() {

        ResponseEntity<MovieResultDto> movieList = testRestTemplate.exchange(
                "/api/oscar-nominees/get-worst-movies-list",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<MovieResultDto>() {
                });

        Assertions.assertThat(movieList).isNotNull();
        Assertions.assertThat(movieList.getBody().getMax()).isNotNull();
        Assertions.assertThat(movieList.getBody().getMin()).isNotNull();

        for (var movie : movieList.getBody().getMin()) {
            assertEquals("Joel Silver", movie.getProducer());
            assertEquals(1, movie.getInterval());
            assertEquals(1990, movie.getPreviousWin());
            assertEquals(1991, movie.getFollowingWin());
        }

        for (var movie : movieList.getBody().getMax()) {
            assertEquals("Matthew Vaughn", movie.getProducer());
            assertEquals(13, movie.getInterval());
            assertEquals(2002, movie.getPreviousWin());
            assertEquals(2015, movie.getFollowingWin());
        }
    }
}
