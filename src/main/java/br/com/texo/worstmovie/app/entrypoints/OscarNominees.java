package br.com.texo.worstmovie.app.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.texo.worstmovie.domain.movielist.entities.MovieResultDto;
import br.com.texo.worstmovie.domain.movielist.usecases.FindMovieListUseCase;

@RestController
@RequestMapping("/api/oscar-nominees")
public class OscarNominees {

    @Autowired
    FindMovieListUseCase findMovieList;

    @GetMapping("/get-worst-movies-list")
    public ResponseEntity<MovieResultDto> producerWithLongerTimePeriodBetweenTwoOscars() {
        MovieResultDto movieResult = findMovieList.execute();

        if (movieResult.getMax() == null && movieResult.getMin() == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok().body(movieResult);

    }
}
