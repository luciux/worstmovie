package br.com.texo.worstmovie.app.movielist.dataproviders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.texo.worstmovie.app.movielist.dataproviders.entities.MovieModel;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {

}
