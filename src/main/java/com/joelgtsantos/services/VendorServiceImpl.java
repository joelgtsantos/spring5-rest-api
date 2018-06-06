/**
 * 
 */
package com.joelgtsantos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.joelgtsantos.api.v1.mapper.VendorMapper;
import com.joelgtsantos.api.v1.model.VendorDTO;
import com.joelgtsantos.api.v1.model.VendorListDTO;
import com.joelgtsantos.controllers.v1.VendorController;
import com.joelgtsantos.domain.Vendor;
import com.joelgtsantos.repositories.VendorRepository;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
@Service
public class VendorServiceImpl implements VendorService {
	
	private final VendorMapper vendorMapper;
	private final VendorRepository vendorRepository;

	/**
	 * @param instance
	 * @param vendorRepository
	 */
	public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
		 this.vendorMapper = vendorMapper;
	     this.vendorRepository = vendorRepository;
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.VendorService#getVendorById(long)
	 */
	@Override
	public VendorDTO getVendorById(Long id) {
		return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .map(vendorDTO -> {
                    vendorDTO.setVendorUrl(getVendorUrl(id));
                    return vendorDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.VendorService#getAllVendors()
	 */
	@Override
	public VendorListDTO getAllVendors() {
		List<VendorDTO> vendorDTOS = vendorRepository
                .findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(getVendorUrl(vendor.getId()));
                    return vendorDTO;
                })
                .collect(Collectors.toList());

        return new VendorListDTO(vendorDTOS);
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.VendorService#createNewVendor(com.joelgtsantos.api.v1.model.VendorDTO)
	 */
	@Override
	public VendorDTO createNewVendor(VendorDTO vendorDTO) {
		return saveAndReturnDTO(vendorMapper.vendorDTOToVendor(vendorDTO));
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.VendorService#saveVendorByDTO(long, com.joelgtsantos.api.v1.model.VendorDTO)
	 */
	@Override
	public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
		 Vendor vendorToSave = vendorMapper.vendorDTOToVendor(vendorDTO);
	        vendorToSave.setId(id);

	        return saveAndReturnDTO(vendorToSave);
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.VendorService#patchVendor(long, com.joelgtsantos.api.v1.model.VendorDTO)
	 */
	@Override
	public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
		return vendorRepository.findById(id)
                .map(vendor -> {
                    //todo if more properties, add more if statements

                    if(vendorDTO.getName() != null){
                        vendor.setName(vendorDTO.getName());
                    }

                    return saveAndReturnDTO(vendor);
                }).orElseThrow(ResourceNotFoundException::new);
	}

	/* (non-Javadoc)
	 * @see com.joelgtsantos.services.VendorService#deleteVendorById(long)
	 */
	@Override
	public void deleteVendorById(Long id) {
		vendorRepository.deleteById(id);
	}
	
	private String getVendorUrl(Long id) {
        return VendorController.BASE_URL + "/" + id;
    }

    private VendorDTO saveAndReturnDTO(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO returnDto = vendorMapper.vendorToVendorDTO(savedVendor);

        returnDto.setVendorUrl(getVendorUrl(savedVendor.getId()));

        return returnDto;
    }

}
