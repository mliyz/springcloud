package com.liyz.fallInLove.web.persion;

import com.liyz.fallInLove.dto.person.VehicleAcceptAddressDto;
import com.liyz.fallInLove.service.persion.VehicleAcceptAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persion/address")
public class VehicleAcceptAddressController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleAcceptAddressController.class);
	
	@Autowired
	private VehicleAcceptAddressService vehicleAcceptAddressService;
	
	@PostMapping("/addVehicleAcceptAddress")
	public String addVehicleAcceptAddress(@RequestBody VehicleAcceptAddressDto vehicleAcceptAddressDto){
		return vehicleAcceptAddressService.addVehicleAcceptAddress(vehicleAcceptAddressDto);
	}
	
}
