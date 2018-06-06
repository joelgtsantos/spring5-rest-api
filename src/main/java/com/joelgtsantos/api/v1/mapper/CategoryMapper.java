/**
 * 
 */
package com.joelgtsantos.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.joelgtsantos.api.v1.model.CategoryDTO;
import com.joelgtsantos.domain.Category;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    CategoryDTO categoryToCategoryDTO(Category category);
}