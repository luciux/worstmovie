package br.com.texo.worstmovie.domain.movielist.entities;

import lombok.Data;

@Data
public class MovieResultFieldsDto {
    String producer;
    Integer interval;
    Integer previousWin;
    Integer followingWin;
}
