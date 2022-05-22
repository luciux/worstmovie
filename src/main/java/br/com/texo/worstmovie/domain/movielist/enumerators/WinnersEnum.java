package br.com.texo.worstmovie.domain.movielist.enumerators;

import lombok.Getter;

@Getter
public enum WinnersEnum {
    WINNER("yes"), LOSER("");

    private String descricao;

    private WinnersEnum(String descricao) {
        this.descricao = descricao;
    }
}
