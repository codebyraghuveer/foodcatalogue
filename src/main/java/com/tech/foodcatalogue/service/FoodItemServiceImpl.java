package com.tech.foodcatalogue.service;

import com.tech.foodcatalogue.dto.FoodCataloguePage;
import com.tech.foodcatalogue.dto.FoodItemDto;
import com.tech.foodcatalogue.dto.RestaurantDto;
import com.tech.foodcatalogue.entity.FoodItem;
import com.tech.foodcatalogue.mapper.FoodItemMapper;
import com.tech.foodcatalogue.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.mapToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.mapToFoodItemDto(savedFoodItem);
    }

    @Override
    public FoodCataloguePage getRestaurantDetailsWithFoodItems(String restaurantCode) {

        //fetch the FoodItems by restaurantId
        List<FoodItemDto> foodItemList = fetchFoodItemsByRestaurantId(restaurantCode);

        //fetch the restaurant by restaurantId
        RestaurantDto restaurantDto = fetchRestaurantDetails(restaurantCode);

        //create the food catalogue and return
        FoodCataloguePage foodCataloguePage = createFoodCataloguePage(foodItemList, restaurantDto);

        return foodCataloguePage;
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItemDto> foodItemList, RestaurantDto restaurantDto) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurantDto(restaurantDto);
        return foodCataloguePage;

    }

    private RestaurantDto fetchRestaurantDetails(String restaurantCode) {
        RestaurantDto restaurantDto = restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchRestaurant/" + restaurantCode, RestaurantDto.class);
        return restaurantDto;
    }

    private List<FoodItemDto> fetchFoodItemsByRestaurantId(String restaurantCode) {
        return foodItemRepository.findByRestaurantCode(restaurantCode)
                .stream()
                .map(foodItem -> FoodItemMapper.INSTANCE.mapToFoodItemDto(foodItem))
                .collect(Collectors.toList());
    }
}
