package br.com.texo.worstmovie.app.movielist.dataproviders.converters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.texo.worstmovie.app.movielist.dataproviders.entities.MovieModel;
import br.com.texo.worstmovie.domain.movielist.entities.MovieDto;

@Component
@Scope("prototype")
public class ConvertMovieListModelToEntity implements ConverterBase<MovieDto, MovieModel> {

    @Override
    public MovieDto convert(MovieModel model) {

        MovieDto entity = new MovieDto();

        entity.setId(model.getId());
        entity.setTitle(model.getTitle());
        entity.setProducers(model.getProducers());
        entity.setStudios(model.getStudios());
        entity.setWinners(model.getWinners());
        entity.setYear(model.getYear());

        return entity;
    }

}
