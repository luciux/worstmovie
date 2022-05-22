package br.com.texo.worstmovie.app.movielist.dataproviders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.texo.worstmovie.app.movielist.dataproviders.converters.ConvertMovieListModelToEntity;
import br.com.texo.worstmovie.app.movielist.dataproviders.repositories.MovieRepository;
import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;
import br.com.texo.worstmovie.domain.movielist.providers.MovieListDataProvider;

@Component
@Scope("prototype")
public class MovieListProvider implements MovieListDataProvider {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ConvertMovieListModelToEntity convertMovieListModelToEntity;

    @Override
    public List<MovieDto> findMovieList() {
        List<MovieDto> movieListDto = new ArrayList<>();
        movieRepository.findAll().forEach(e -> {
            movieListDto.add(convertMovieListModelToEntity.convert(e));
        });

        return movieListDto;
    }
}
