package br.com.texo.worstmovie.app.movielist.dataproviders.converters;

public interface ConverterBase<T, U> {
    T convert(U model);
}
