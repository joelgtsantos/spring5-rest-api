/**
 * 
 */
package com.joelgtsantos.services;

import com.joelgtsantos.api.v1.model.VendorDTO;
import com.joelgtsantos.api.v1.model.VendorListDTO;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
public interface VendorService {

	/**
	 * @param l
	 * @return
	 */
	VendorDTO getVendorById(Long id);

	/**
	 * @return
	 */
	VendorListDTO getAllVendors();

	/**
	 * @param vendorDTO
	 * @return
	 */
	VendorDTO createNewVendor(VendorDTO vendorDTO);

	/**
	 * @param id1
	 * @param vendorDTO
	 * @return
	 */
	VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

	/**
	 * @param id1
	 * @param vendorDTO
	 * @return
	 */
	VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

	/**
	 * @param l
	 */
	void deleteVendorById(Long id);

}
