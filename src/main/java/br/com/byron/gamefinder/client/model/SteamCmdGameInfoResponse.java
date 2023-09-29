package br.com.byron.gamefinder.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SteamCmdGameInfoResponse {

    private List<String> tags;

    @JsonProperty("common")
    public void setData(Map<String, Object> data) {
        if (data.get("store_tags") instanceof LinkedHashMap<?, ?>) {
            List<String> tags = new ArrayList<>();
            LinkedHashMap<String, String> tagsInfo = (LinkedHashMap<String, String>) data.get("store_tags");
            for (Object tagId : tagsInfo.values()) {
                tags.add(tagId.toString());
            }
            this.tags = tags;
        }
    }


}
