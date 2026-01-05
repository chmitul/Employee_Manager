package org.manager.managerfeign;

import org.manager.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "employee-service",
						 url = "http://localhost:8080")
public interface EmployeeFeignClient
{
	@GetMapping("employee/Employees/{managerId}")
	List<EmployeeDto> getAllEmployeeForManager(@PathVariable Integer managerId);
}
