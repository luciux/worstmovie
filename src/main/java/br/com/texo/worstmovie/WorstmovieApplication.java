package br.com.texo.worstmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(" br.com.texo.worstmovie.app.movielist.entities")
@EnableJpaRepositories("br.com.texo.worstmovie.app.movielist.repositories")
public class WorstmovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorstmovieApplication.class, args);
	}

}
