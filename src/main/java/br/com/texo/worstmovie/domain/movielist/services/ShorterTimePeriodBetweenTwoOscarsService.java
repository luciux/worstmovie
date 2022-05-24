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
import br.com.texo.worstmovie.domain.movielist.usecases.GetProducerNameUseCase;
import br.com.texo.worstmovie.domain.movielist.usecases.ShorterTimePeriodBetweenTwoOscarsUseCase;

@Component
@Scope("prototype")
public class ShorterTimePeriodBetweenTwoOscarsService implements ShorterTimePeriodBetweenTwoOscarsUseCase {

    @Autowired
    CreateMovieResultFieldsUseCase createMovieResultFields;

    @Autowired
    GetProducerNameUseCase getProducerName;

    @Override
    public List<MovieResultFieldsDto> execute(List<MovieDto> movies) {
        Integer interval = Integer.MAX_VALUE;
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
                String[] producerBegin = getProducerName.execute(filteredMovies.get(i).getProducers());
                String[] producerEnd = getProducerName.execute(filteredMovies.get(cont).getProducers());

                for (String pb : producerBegin) {
                    for (String pe : producerEnd) {
                        if (pb.equals(pe)) {
                            Integer oscarInterval = filteredMovies.get(cont).getYear()
                                    - filteredMovies.get(i).getYear();
                            if (oscarInterval > 0 && oscarInterval < interval) {
                                result.clear();
                                interval = oscarInterval;
                                result.add(createMovieResultFields.execute(pb, filteredMovies.get(i),
                                        filteredMovies.get(cont)));
                            } else if (oscarInterval > 0 && oscarInterval.equals(interval)) {
                                result.add(createMovieResultFields.execute(pb, filteredMovies.get(i),
                                        filteredMovies.get(cont)));
                            }
                        }
                    }
                }

            }
        }
        return result;
    }
}
