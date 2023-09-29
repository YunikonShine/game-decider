package br.com.byron.gamefinder.client;

import br.com.byron.gamefinder.client.model.SteamCmdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SteamCmdClient", url = "${api.url.steamCmd}")
public interface SteamCmdClient {

    @GetMapping("/info/{id}")
    SteamCmdResponse getGameInfo(@PathVariable String id);

}
