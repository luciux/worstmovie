package br.com.texo.worstmovie.app.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadMoviesFromCsv {
    Class clazz = LoadMoviesFromCsv.class;

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    @Bean
    public String getMovieListFromCsv() throws IOException {
        InputStream input = clazz.getResourceAsStream("/csv/movielist.csv");
        String result = readFromInputStream(input);
        return result;
    }
}
