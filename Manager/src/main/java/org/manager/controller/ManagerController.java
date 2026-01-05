package org.manager.controller;

import lombok.RequiredArgsConstructor;
import org.manager.dto.EmployeeDto;
import org.manager.dto.ManagerDto;
import org.manager.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/manager")
@RequiredArgsConstructor
public class ManagerController
{
	private final ManagerService managerService;

	@GetMapping(value = "/getbyid/{id}")
	public ResponseEntity<ManagerDto> getManagerById(@PathVariable Integer id)
	{
		ManagerDto managerByIdDetails = managerService.getManagerbyId(id);
		return ResponseEntity.ok(managerByIdDetails);
	}

	@GetMapping(value = "/getall")
	public ResponseEntity<List<ManagerDto>> getAllManagers()
	{
		List<ManagerDto> managers = managerService.getAllManagers();
		return ResponseEntity.ok(managers);
	}

	@GetMapping(value = "/getbyemail/{email}")
	public ResponseEntity<ManagerDto> getManagerByEmail(@PathVariable String email)
	{
		ManagerDto managerByEmailDetails = managerService.getManagerbyEmail(email);
		return ResponseEntity.ok(managerByEmailDetails);
	}

	@GetMapping(value = "managers/{id}/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeeForManager(
					@PathVariable Integer id)
	{
		return ResponseEntity.ok(managerService.getAllEmployeesForManager(id));
	}
}
