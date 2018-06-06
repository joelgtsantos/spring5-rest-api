/**
 * 
 */
package com.joelgtsantos.services;

import java.util.List;

import com.joelgtsantos.api.v1.model.CustomerDTO;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
public interface CustomerService {
	List<CustomerDTO> getAllCustomers();
	
	CustomerDTO getCustomerById(long id);

	/**
	 * @param customerDTO
	 * @return
	 */
	CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	
	CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

	/**
	 * @param id
	 * @param customerDTO
	 * @return
	 */
	CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

	/**
	 * @param id
	 */
	void deleteCustomerById(Long id);
}
