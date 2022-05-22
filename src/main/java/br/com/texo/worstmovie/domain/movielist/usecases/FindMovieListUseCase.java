package br.com.texo.worstmovie.domain.movielist.usecases;

import br.com.texo.worstmovie.domain.movielist.entities.MovieResultDto;

public interface FindMovieListUseCase {
    MovieResultDto execute();
}
