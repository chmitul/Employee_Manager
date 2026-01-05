package org.employee.feign;

import org.employee.dto.ManagerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "manager-service",
						 url = "http://localhost:8081")
public interface ManagerFeignClient
{
	@GetMapping("/manager/getbyid/{id}")
	ManagerDto getManagerById(@PathVariable Integer id);
}
