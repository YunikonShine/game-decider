package br.com.byron.gamefinder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameInfoResponse {

    private String id;

    private String name;

    private String image;

    private String price;

    private String finalPrice;

    private String discount;

}
