package com.mouritech.onlinefooddeliveryapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefooddeliveryapplication.entity.Item;
import com.mouritech.onlinefooddeliveryapplication.entity.Restaurant;
import com.mouritech.onlinefooddeliveryapplication.exception.RestaurantNotFound;
import com.mouritech.onlinefooddeliveryapplication.repository.ItemsRepository;
import com.mouritech.onlinefooddeliveryapplication.repository.RestaurantRepository;
import com.mouritech.onlinefooddeliveryapplication.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	ItemsRepository itemsRepository;

	@Override
	public Item addItems(Long restaurantId, Item item) throws RestaurantNotFound {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantNotFound(" restaurant not Found"));
		item.setRestaurant(restaurant);
		Item finalItems = itemsRepository.save(item);
		return finalItems;
	}
}