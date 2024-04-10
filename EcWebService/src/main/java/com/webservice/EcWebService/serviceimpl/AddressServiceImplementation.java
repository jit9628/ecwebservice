package com.webservice.EcWebService.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.EcWebService.entity.Address;
import com.webservice.EcWebService.repository.AddressRepository;
import com.webservice.EcWebService.service.AddressService;

@Service
public class AddressServiceImplementation implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public String addAddress(Address address) {
	   
	   if(this.addressRepository.save(address) instanceof Address) {
		   return "Address Saved";
	   }else {
		   
	   
	   return "Getting Problem .. ";
	   
	   
	   
	   }
	}

}
