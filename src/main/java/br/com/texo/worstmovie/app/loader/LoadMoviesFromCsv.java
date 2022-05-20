package br.com.texo.worstmovie.app.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.texo.worstmovie.app.movielist.entities.MovieEntity;
import br.com.texo.worstmovie.app.movielist.repositories.MovieListRepositoty;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class LoadMoviesFromCsv {

    @Autowired
    private MovieListRepositoty movieRepository;

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

    public String getMovieListFromCsv() throws IOException {
        Class clazz = LoadMoviesFromCsv.class;
        InputStream input = clazz.getResourceAsStream("/csv/movielist.csv");
        String result = readFromInputStream(input);
        return result;
    }

    @PostConstruct
    public void saveFromCsvToMem() throws IOException {
        String[] movies = getMovieListFromCsv().split("\n");
        Boolean alreadySkippedTitle = false;
        for (String movie : movies) {
            if (alreadySkippedTitle) {
                String[] splitStringMovie = movie.split(";");
                MovieEntity movieEntity = new MovieEntity();
                movieEntity.setYear(Integer.valueOf(splitStringMovie[0]));
                movieEntity.setTitle(splitStringMovie[1]);
                movieEntity.setStudios(splitStringMovie[2]);
                movieEntity.setProducers(splitStringMovie[3]);
                if (splitStringMovie.length > 4)
                    movieEntity.setWinners(splitStringMovie[4]);
                movieRepository.save(movieEntity);
            } else
                alreadySkippedTitle = true;

        }
    }
}
