package br.com.texo.worstmovie.app.entrypoints;

import java.util.Optional;

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

        if ((Optional.ofNullable(movieResult.getMax()).isEmpty() || movieResult.getMax().size() == 0) &&
                (Optional.ofNullable(movieResult.getMin()).isEmpty() || movieResult.getMin().size() == 0))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok().body(movieResult);

    }
}
