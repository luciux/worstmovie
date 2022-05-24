package br.com.texo.worstmovie.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.texo.worstmovie.domain.movielist.usecases.GetProducerNameUseCase;
import br.com.texo.worstmovie.domain.movielist.services.GetProducerNameService;

public class GetProducerNameUseCaseTest {

    private GetProducerNameUseCase getProducerNames;

    @BeforeEach
    public void onBeforeEach() {
        getProducerNames = new GetProducerNameService();
    }

    @Test
    public void testSplit() {
        String[] result = getProducerNames.execute(
                "Steven Perry and Joel Silver");

        assertTrue(result.length > 1);
    }

}
