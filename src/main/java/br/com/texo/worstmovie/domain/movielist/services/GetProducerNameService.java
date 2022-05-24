package br.com.texo.worstmovie.domain.movielist.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.texo.worstmovie.domain.movielist.usecases.GetProducerNameUseCase;
import lombok.AllArgsConstructor;

@Component
@Scope("prototype")
@AllArgsConstructor
public class GetProducerNameService implements GetProducerNameUseCase {

    @Override
    public String[] execute(String producers) {
        String patternString = "[\\,]|\sand\s";
        return producers.split(patternString);
    }

}
