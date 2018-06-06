/**
 * 
 */
package com.joelgtsantos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joelgtsantos.domain.Vendor;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
