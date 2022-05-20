package br.com.texo.worstmovie.domain.movielist.providers;

import java.util.List;

import br.com.texo.worstmovie.domain.movielist.entities.MovieListDto;

public interface MovieListDataProvider {
    List<MovieListDto> findMovieList();
}
