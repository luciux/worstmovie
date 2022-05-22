package br.com.texo.worstmovie.domain.movielist.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;
import br.com.texo.worstmovie.domain.movielist.entities.MovieResultFieldsDto;
import br.com.texo.worstmovie.domain.movielist.usecases.CreateMovieResultFieldsUseCase;
import br.com.texo.worstmovie.domain.movielist.usecases.LongerTimePeriodBetweenTwoOscarsUseCase;

@Component
@Scope("prototype")
public class LongerTimePeriodBetweenTwoOscarsService implements LongerTimePeriodBetweenTwoOscarsUseCase {

    @Autowired
    CreateMovieResultFieldsUseCase createMovieResultFields;

    @Override
    public List<MovieResultFieldsDto> execute(List<MovieDto> movies) {
        Integer interval = 0;
        List<MovieResultFieldsDto> result = new ArrayList<>();
        List<MovieDto> filteredMovies = movies.stream()
                .filter(e -> e.getWinners().equals(true))
                .sorted(Comparator.comparingInt(MovieDto::getYear))
                .collect(Collectors.toList());

        if (!Optional.ofNullable(filteredMovies).isPresent() || filteredMovies.size() <= 1) {
            return result;
        }

        for (Integer i = 0; i < filteredMovies.size() - 1; i++) {
            for (Integer cont = i + 1; cont < filteredMovies.size(); cont++) {
                Boolean sameProducer = filteredMovies.get(i).getProducers()
                        .equals(filteredMovies.get(cont).getProducers());
                Integer oscarInterval = filteredMovies.get(cont).getYear() - filteredMovies.get(i).getYear();
                if (sameProducer && (oscarInterval > 0 && oscarInterval > interval)) {
                    result.clear();
                    interval = oscarInterval;
                    result.add(createMovieResultFields.execute(filteredMovies.get(i), filteredMovies.get(cont)));
                } else if (sameProducer && (oscarInterval > 0 && oscarInterval.equals(interval))) {
                    result.add(createMovieResultFields.execute(filteredMovies.get(i), filteredMovies.get(cont)));
                }
            }
        }
        return result;
    }
}
