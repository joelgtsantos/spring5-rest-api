/**
 * 
 */
package com.joelgtsantos.services;

import com.joelgtsantos.api.v1.model.CustomerDTO;
import com.joelgtsantos.controllers.v1.CustomerController;
import com.joelgtsantos.domain.Customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.joelgtsantos.api.v1.mapper.CustomerMapper;
import com.joelgtsantos.repositories.CustomerRepository;

/**
 * @author Joel Santos
 *
 *         spring5-rest-api 2018
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;

	/**
	 * @param customerMapper
	 * @param customerRepository
	 */
	public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	/**
	 * @return
	 */
	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll().stream().map(customer -> {
			CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
			customerDTO.setCustomerUrl(getCustomerUrl(customer.getId()));
			return customerDTO;
		}).collect(Collectors.toList());
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public CustomerDTO getCustomerById(long id) {
		return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .map(customerDTO -> {
                    //set API URL
                    customerDTO.setCustomerUrl(getCustomerUrl(id));
                    return customerDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.CustomerService#createNewCustomer(com.joelgtsantos.api.v1.model.CustomerDTO)
	 */
	@Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);

        return saveAndReturnDTO(customer);
    }
	
	private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);

        returnDto.setCustomerUrl(getCustomerUrl(savedCustomer.getId()));

        return returnDto;
    }

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.CustomerService#saveCustomerByDTO(java.lang.Long, com.joelgtsantos.api.v1.model.CustomerDTO)
	 */
	@Override
	public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);

        return saveAndReturnDTO(customer);
    }
	
	@Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {

            if(customerDTO.getFirstname() != null){
                customer.setFirstname(customerDTO.getFirstname());
            }

            if(customerDTO.getLastname() != null){
                customer.setLastname(customerDTO.getLastname());
            }

            CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));

            returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.CustomerService#deleteCustomerById(java.lang.Long)
	 */
	@Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
	
	private String getCustomerUrl(Long id) {
        return CustomerController.BASE_URL + "/" + id;
    }

}
