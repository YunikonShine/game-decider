package br.com.byron.gamefinder.service;

import br.com.byron.gamefinder.client.SteamCmdClient;
import br.com.byron.gamefinder.client.SteamCommunityClient;
import br.com.byron.gamefinder.client.model.SteamCmdResponse;
import br.com.byron.gamefinder.client.model.SteamGameFinderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SteamService {

    private final SteamCommunityClient steamCommunityClient;

    private final SteamCmdClient steamCmdClient;

    public List<SteamGameFinderResponse> findGames(String title) {
        return steamCommunityClient.findGames(title);
    }

    public List<String> listCommonTags(List<String> gameIds) {
        Map<String, Integer> tagCount = new HashMap<>();
        for (String gameId : gameIds) {
            SteamCmdResponse cmdResponse = steamCmdClient.getGameInfo(gameId);
            List<String> tags = cmdResponse.getGameInfo().getTags();
            for (String tag : tags) {
                if (tagCount.containsKey(tag)) {
                    tagCount.put(tag, tagCount.get(tag) + 1);
                } else {
                    tagCount.put(tag, 1);
                }
            }
        }
        return tagCount.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());

    }

}
