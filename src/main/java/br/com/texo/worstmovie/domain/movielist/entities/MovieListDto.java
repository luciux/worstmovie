package br.com.texo.worstmovie.domain.movielist.entities;

import lombok.Data;

@Data
public class MovieListDto {
    private Long id;
    private Integer year;
    private String title;
    private String studios;
    private String producers;
    private Boolean winners;
}
