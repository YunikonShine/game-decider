package br.com.byron.gamefinder.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SteamGameFinderResponse {

    @JsonProperty("appid")
    private String id;

    private String name;

    private String logo;

    private String icon;

}
