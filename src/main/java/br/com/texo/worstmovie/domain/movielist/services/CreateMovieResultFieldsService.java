package br.com.texo.worstmovie.domain.movielist.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;
import br.com.texo.worstmovie.domain.movielist.entities.MovieResultFieldsDto;
import br.com.texo.worstmovie.domain.movielist.usecases.CreateMovieResultFieldsUseCase;

@Component
@Scope("prototype")
public class CreateMovieResultFieldsService implements CreateMovieResultFieldsUseCase {

    @Override
    public MovieResultFieldsDto execute(MovieDto movieInitial, MovieDto movieFinal) {
        MovieResultFieldsDto movieResultFieldsDto = new MovieResultFieldsDto();

        movieResultFieldsDto.setProducer(movieInitial.getProducers());
        movieResultFieldsDto.setInterval(movieFinal.getYear() - movieInitial.getYear());
        movieResultFieldsDto.setPreviousWin(movieInitial.getYear());
        movieResultFieldsDto.setFollowingWin(movieFinal.getYear());

        return movieResultFieldsDto;
    }

}
