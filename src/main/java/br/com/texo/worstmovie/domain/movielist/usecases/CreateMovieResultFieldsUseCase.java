package br.com.texo.worstmovie.domain.movielist.usecases;

import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;
import br.com.texo.worstmovie.domain.movielist.entities.MovieResultFieldsDto;

public interface CreateMovieResultFieldsUseCase {
    MovieResultFieldsDto execute(String producerName, MovieDto movieInitial, MovieDto movieFinal);
}
