package br.com.texo.worstmovie.app.movielist.dataproviders.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MOVIE_LIST")
@Getter
@Setter
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "YEAR", nullable = false)
    private Integer year;

    @Column(name = "TITLE", length = 300, nullable = false)
    private String title;

    @Column(name = "STUDIOS", length = 300, nullable = false)
    private String studios;

    @Column(name = "PRODUCERS", length = 300, nullable = false)
    private String producers;

    @Column(name = "WINNERS", length = 3, nullable = true)
    private String winners;
}
