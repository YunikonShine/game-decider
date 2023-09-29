package br.com.byron.gamefinder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class GameFinderApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(GameFinderApplication.class, args);
	}

}
