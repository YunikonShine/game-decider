package br.com.byron.gamefinder.controller;

import br.com.byron.gamefinder.client.model.SteamGameFinderResponse;
import br.com.byron.gamefinder.service.SteamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FindController {

    private SteamService steamService;

    @GetMapping("/{title}")
    public List<SteamGameFinderResponse> findGames(@PathVariable String title) {
        return steamService.findGames(title);
    }

}
