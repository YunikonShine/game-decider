package br.com.byron.gamefinder.service;

import br.com.byron.gamefinder.client.SteamCmdClient;
import br.com.byron.gamefinder.client.SteamCommunityClient;
import br.com.byron.gamefinder.client.model.SteamCmdResponse;
import br.com.byron.gamefinder.model.GameInfoResponse;
import br.com.byron.gamefinder.model.GameSearchResponse;
import br.com.byron.gamefinder.model.mapper.GameInfoMapper;
import br.com.byron.gamefinder.model.mapper.GameSearchMapper;
import br.com.byron.gamefinder.utils.SteamUtils;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SteamService {

    private final SteamCommunityClient steamCommunityClient;

    private final SteamCmdClient steamCmdClient;

    private final SteamUtils steamUtils;

    private final GameSearchMapper gameSearchMapper;

    private final GameInfoMapper gameInfoMapper;

    public List<GameSearchResponse> findGames(String title) {
        return gameSearchMapper.toGameSearchResponse(steamCommunityClient.findGames(title));
    }

    private List<String> listCommonTags(List<String> gameIds) {
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

    public List<GameInfoResponse> getGamesByTags(List<String> gameIds) {
        List<String> commonTags = listCommonTags(gameIds);
        String steamURL = steamUtils.getSteamStoreUrl(commonTags.subList(0, 10));

        List<GameInfoResponse> games = new ArrayList<>();

        try {
            Document document = Jsoup.connect(steamURL).get();
            Element element = document.getElementById("search_resultsRows");
            if (element != null) {
                List<Element> children = element.children();
                for (Element item : children) {
                    String[] image = item.getElementsByClass("search_capsule").html().split("/");

                    if (image.length > 5) {
                        games.add(gameInfoMapper.toGameInfoResponse(item, image[5]));
                    }

                    if (games.size() == 10) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
        }

        return games;
    }

}
