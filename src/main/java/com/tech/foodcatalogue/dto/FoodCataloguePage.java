package com.tech.foodcatalogue.dto;

import com.tech.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {

    private List<FoodItemDto> foodItemList;
    private RestaurantDto restaurantDto;

}
