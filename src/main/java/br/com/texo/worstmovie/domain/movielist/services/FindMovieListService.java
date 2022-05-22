package br.com.texo.worstmovie.domain.movielist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;
import br.com.texo.worstmovie.domain.movielist.entities.MovieResultDto;
import br.com.texo.worstmovie.domain.movielist.providers.MovieListDataProvider;
import br.com.texo.worstmovie.domain.movielist.usecases.FindMovieListUseCase;
import br.com.texo.worstmovie.domain.movielist.usecases.LongerTimePeriodBetweenTwoOscarsUseCase;
import br.com.texo.worstmovie.domain.movielist.usecases.ShorterTimePeriodBetweenTwoOscarsUseCase;

@Component
@Scope("prototype")
public class FindMovieListService implements FindMovieListUseCase {

    @Autowired
    MovieListDataProvider movieListDataProvider;

    @Autowired
    LongerTimePeriodBetweenTwoOscarsUseCase longerTimePeriodBetweenTwoOscars;

    @Autowired
    ShorterTimePeriodBetweenTwoOscarsUseCase shorterTimePeriodBetweenTwoOscars;

    @Override
    public MovieResultDto execute() {
        MovieResultDto movieResultDto = new MovieResultDto();
        List<MovieDto> movies = movieListDataProvider.findMovieList();

        movieResultDto.setMin(shorterTimePeriodBetweenTwoOscars.execute(movies));
        movieResultDto.setMax(longerTimePeriodBetweenTwoOscars.execute(movies));

        return movieResultDto;
    }
}
