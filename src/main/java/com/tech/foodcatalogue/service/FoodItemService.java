package com.tech.foodcatalogue.service;

import com.tech.foodcatalogue.dto.FoodCataloguePage;
import com.tech.foodcatalogue.dto.FoodItemDto;
import com.tech.foodcatalogue.entity.FoodItem;

public interface FoodItemService {

    FoodItemDto addFoodItem(FoodItemDto foodItemDto);

    FoodCataloguePage getRestaurantDetailsWithFoodItems(String restaurantCode);
}
