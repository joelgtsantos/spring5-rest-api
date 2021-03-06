/**
 * 
 */
package com.joelgtsantos.api.v1.model;

import java.util.List;

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
@AllArgsConstructor
@NoArgsConstructor
public class VendorListDTO {

    List<VendorDTO> vendors;
}
