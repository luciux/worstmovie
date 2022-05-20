package br.com.texo.worstmovie.app.movielist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.texo.worstmovie.app.movielist.entities.MovieEntity;

public interface MovieListRepositoty extends JpaRepository<MovieEntity, Long> {

}
