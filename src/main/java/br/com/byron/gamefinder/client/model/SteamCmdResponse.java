package br.com.byron.gamefinder.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SteamCmdResponse {

    private SteamCmdGameInfoResponse gameInfo;

    @JsonProperty("data")
    public void setData(LinkedHashMap<Integer, SteamCmdGameInfoResponse> data) {
        this.gameInfo = data.values().stream().findFirst().get();
    }

}
