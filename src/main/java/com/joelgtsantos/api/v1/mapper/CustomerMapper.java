/**
 * 
 */
package com.joelgtsantos.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.joelgtsantos.api.v1.model.CustomerDTO;
import com.joelgtsantos.domain.Customer;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);
    
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}