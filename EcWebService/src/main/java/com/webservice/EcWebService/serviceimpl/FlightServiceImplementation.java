package com.webservice.EcWebService.serviceimpl;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.EcWebService.entity.Flight;
import com.webservice.EcWebService.repository.FlightRepository;
import com.webservice.EcWebService.service.FlightService;
@Service
public class FlightServiceImplementation implements FlightService {
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public String addFlight(Flight flight) {
	
		if(this.flightRepository.save(flight) instanceof Flight) {
			return "Alight Add";
		}else {
			return "Getting Problem";
		}
		
	}

}
