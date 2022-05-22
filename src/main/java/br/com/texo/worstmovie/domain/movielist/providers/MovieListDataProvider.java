package br.com.texo.worstmovie.domain.movielist.providers;

import java.util.List;

import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;

public interface MovieListDataProvider {
    List<MovieDto> findMovieList();
}
