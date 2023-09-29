package br.com.byron.gamefinder.model.mapper;

import br.com.byron.gamefinder.client.model.SteamGameFinderResponse;
import br.com.byron.gamefinder.model.GameSearchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameSearchMapper {

    @Mapping(source = "id", target = "image", qualifiedByName = "setUrlNamed")
    GameSearchResponse toGameSearchResponse(SteamGameFinderResponse steamGameFinderResponse);

    List<GameSearchResponse> toGameSearchResponse(List<SteamGameFinderResponse> steamGameFinderResponse);

    @Named("setUrlNamed")
    default String setUrl(String id) {
        return "https://cdn.akamai.steamstatic.com/steam/apps/" + id + "/capsule_231x87.jpg";
    }

}
