package br.com.byron.gamefinder.controller;

import br.com.byron.gamefinder.model.GameInfoResponse;
import br.com.byron.gamefinder.model.GameSearchResponse;
import br.com.byron.gamefinder.model.IdRequest;
import br.com.byron.gamefinder.service.SteamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FindController {

    private SteamService steamService;

    @GetMapping("/{title}")
    public List<GameSearchResponse> findGames(@PathVariable String title) {
        return steamService.findGames(title);
    }

    @PostMapping("/search")
    public List<GameInfoResponse> search(@RequestBody IdRequest idRequest) {
        return steamService.getGamesByTags(idRequest.getIds());
    }

}
