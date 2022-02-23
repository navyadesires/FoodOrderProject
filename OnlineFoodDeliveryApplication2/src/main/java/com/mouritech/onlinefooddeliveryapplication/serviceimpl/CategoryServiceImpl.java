/*package com.mouritech.onlinefooddeliveryapplication.serviceimpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefooddeliveryapplication.entity.Category;
import com.mouritech.onlinefooddeliveryapplication.exception.CategoryNotFound;
import com.mouritech.onlinefooddeliveryapplication.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category insertCategory(Category newCategory) {
	
		newCategory.setCatId(generateCatId());
		return categoryRepository.save(newCategory);
	}
	
	
	public String generateCatId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long cId = (long) rand.nextInt(upperbound);
		return "CAT00" + cId; 
	
	}


	@Override
	public Category showCatById(int catId) throws CategoryNotFound {
		// TODO Auto-generated method stub
		return categoryRepository.findByCatId(catId).orElseThrow(() -> new CategoryNotFoundException("category not found with id " + catId));
	}


	@Override
	public List<Category> showAllCategorys() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}


	@Override
	public Category updateCatById(String catId,Category category) throws CategoryNotFound{
		Category existingCategory = categoryRepository.findByCatId(catId).orElseThrow(() -> new CategoryNotFoundException("category not found with id " + catId));
		existingCategory.setCatName(category.getCatName());
		
		categoryRepository.save(existingCategory);
		return existingCategory;
	}


	@Override
	public void deleteCatById(String catId) throws CategoryNotFound {
		Category existingCategory = categoryRepository.findByCatId(catId).orElseThrow(() -> new CategoryNotFoundException("category not found with id " + catId));
		categoryRepository.delete(existingCategory);
	}

}*/
