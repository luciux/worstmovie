package br.com.texo.worstmovie.app.movielist.entities;

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
@AllArgsConstructor
public class MovieEntity {
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

    public Long getId() {
        return this.id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getStudios() {
        return this.studios;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getProducers() {
        return this.producers;
    }

    public void setWinners(String winners) {
        this.winners = winners;
    }

    public String getWinners() {
        return this.winners;
    }
}
