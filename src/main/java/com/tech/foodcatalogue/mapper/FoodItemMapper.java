package com.tech.foodcatalogue.mapper;

import com.tech.foodcatalogue.dto.FoodItemDto;
import com.tech.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapToFoodItem(FoodItemDto foodItemDto);

    FoodItemDto mapToFoodItemDto(FoodItem foodItem);

}
