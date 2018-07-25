package com.liyz.fallInLove.service.persion;

import com.liyz.fallInLove.dto.person.VehicleAcceptAddressDto;
import com.liyz.fallInLove.service.impl.persion.VehicleAcceptAddressServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-service",fallback = VehicleAcceptAddressServiceImpl.class)
public interface VehicleAcceptAddressService {
	@PostMapping("/persion/address/addVehicleAcceptAddress")
	String addVehicleAcceptAddress(@RequestBody VehicleAcceptAddressDto vehicleAcceptAddressDto);
}
