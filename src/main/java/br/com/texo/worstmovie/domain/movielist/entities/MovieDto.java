package br.com.texo.worstmovie.domain.movielist.entities;

import br.com.texo.worstmovie.domain.movielist.enumerators.WinnersEnum;
import lombok.Data;

@Data
public class MovieDto {
    private Long id;
    private Integer year;
    private String title;
    private String studios;
    private String producers;
    private Boolean winners;

    public void setWinners(String desc) {
        this.winners = WinnersEnum.WINNER.getDescricao().equals(desc);
    }
}
