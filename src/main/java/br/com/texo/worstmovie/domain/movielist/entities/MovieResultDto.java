package br.com.texo.worstmovie.domain.movielist.entities;

import java.util.List;

import lombok.Data;

@Data
public class MovieResultDto {
    List<MovieResultFieldsDto> min;
    List<MovieResultFieldsDto> max;
}
