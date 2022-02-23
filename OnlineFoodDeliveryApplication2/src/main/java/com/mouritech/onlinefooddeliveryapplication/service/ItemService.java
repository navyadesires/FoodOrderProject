package com.mouritech.onlinefooddeliveryapplication.service;

import com.mouritech.onlinefooddeliveryapplication.entity.Item;
import com.mouritech.onlinefooddeliveryapplication.exception.RestaurantNotFound;


public interface ItemService {

	Item addItems(Long restaurantId, Item item) throws RestaurantNotFound;

}
