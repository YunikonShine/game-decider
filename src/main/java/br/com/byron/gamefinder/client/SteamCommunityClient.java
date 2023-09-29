package br.com.byron.gamefinder.client;

import br.com.byron.gamefinder.client.model.SteamGameFinderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "SteamCommunityClient", url = "${api.url.steamCommunity}")
public interface SteamCommunityClient {

    @GetMapping("/actions/SearchApps/{title}")
    List<SteamGameFinderResponse> findGames(@PathVariable String title);

}
