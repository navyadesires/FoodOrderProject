package com.mouritech.onlinefooddeliveryapplication.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mouritech.onlinefooddeliveryapplication.dto.RestaurantDto;
import com.mouritech.onlinefooddeliveryapplication.dto.RestaurantItemsDto;
import com.mouritech.onlinefooddeliveryapplication.entity.Restaurant;

@Component
public class RestaurantItemsMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	public RestaurantItemsDto convertEntityToDto(Restaurant restaurant)
	{
		return modelMapper.map(restaurant, RestaurantItemsDto.class);
	}
	
	public Restaurant convertDtoToEntity(RestaurantItemsDto restaurantItemsDto)
	{
		return modelMapper.map(restaurantItemsDto,Restaurant.class);
	}


}
