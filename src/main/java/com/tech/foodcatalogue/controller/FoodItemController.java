package com.tech.foodcatalogue.controller;

import com.tech.foodcatalogue.dto.FoodCataloguePage;
import com.tech.foodcatalogue.dto.FoodItemDto;
import com.tech.foodcatalogue.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
@CrossOrigin("*")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/addFoodItems")
    public ResponseEntity<FoodItemDto> addFoodItems(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto addedFoodItem = foodItemService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(addedFoodItem, HttpStatus.CREATED);
    }
    @GetMapping("/fetchRestaurants/{restaurantCode}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodItems(@PathVariable String restaurantCode){
        FoodCataloguePage restaurantDetailsWithFoodItems = foodItemService.getRestaurantDetailsWithFoodItems(restaurantCode);
        return new ResponseEntity<>(restaurantDetailsWithFoodItems,HttpStatus.OK);
    }

}
