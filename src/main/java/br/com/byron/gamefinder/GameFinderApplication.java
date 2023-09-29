package br.com.byron.gamefinder;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameFinderApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(GameFinderApplication.class, args);
    }

}
