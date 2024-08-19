package com.tech.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
    private String restaurantCode;

}
