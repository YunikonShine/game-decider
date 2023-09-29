package br.com.byron.gamefinder.service;

import br.com.byron.gamefinder.client.SteamCommunityClient;
import br.com.byron.gamefinder.client.model.SteamGameFinderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SteamService {

    private final SteamCommunityClient steamCommunityClient;

    public List<SteamGameFinderResponse> findGames(String title) {
        return steamCommunityClient.findGames(title);
    }

}
