/**
 * 
 */
package com.joelgtsantos.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class VendorDTO {
    private String name;

    @JsonProperty("vendor_url")
    private String vendorUrl;
}
