/**
 * 
 */
package com.joelgtsantos.services;

import java.util.List;

import com.joelgtsantos.api.v1.model.CategoryDTO;

/**
 * @author Joel Santos
 *
 *         spring5-rest-api 2018
 */
public interface CategoryService {
	List<CategoryDTO> getAllCategories();

	CategoryDTO getCategoryByName(String name);

}
