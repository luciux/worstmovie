package br.com.texo.worstmovie.domain.movielist.usecases;

import java.util.List;

import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;
import br.com.texo.worstmovie.domain.movielist.entities.MovieResultFieldsDto;

public interface LongerTimePeriodBetweenTwoOscarsUseCase {
    List<MovieResultFieldsDto> execute(List<MovieDto> movies);
}
