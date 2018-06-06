/**
 * 
 */
package com.joelgtsantos.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.joelgtsantos.api.v1.model.VendorDTO;
import com.joelgtsantos.domain.Vendor;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);
    
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}