/**
 * 
 */
package com.joelgtsantos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joelgtsantos.domain.Category;
/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
