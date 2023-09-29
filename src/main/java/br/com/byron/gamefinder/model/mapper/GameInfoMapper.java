package br.com.byron.gamefinder.model.mapper;

import br.com.byron.gamefinder.model.GameInfoResponse;
import org.jsoup.nodes.Element;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GameInfoMapper {

    @Mapping(source = "id", target = "image", qualifiedByName = "setUrlNamed")
    @Mapping(source = "id", target = "id")
    GameInfoResponse toGameInfoResponse(Element item, String id);

    @Named("setUrlNamed")
    default String setUrl(String id) {
        return "https://cdn.akamai.steamstatic.com/steam/apps/" + id + "/capsule_231x87.jpg";
    }

    @AfterMapping
    default void setFields(Element item, @MappingTarget GameInfoResponse gameInfoResponse) {
        gameInfoResponse.setName(item.getElementsByClass("title").html());
        gameInfoResponse.setDiscount(item.getElementsByClass("discount_pct").html());
        gameInfoResponse.setPrice(item.getElementsByClass("discount_original_price").html());
        gameInfoResponse.setFinalPrice(item.getElementsByClass("discount_final_price").html());
    }

}
