/**
 * 
 */
package com.joelgtsantos.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	
	@ApiModelProperty(value = "This is the first name", required = true)
	private String firstname;
	
	@ApiModelProperty(required = true )
    private String lastname;
    
    @JsonProperty("customer_url")
    private String customerUrl;
}
