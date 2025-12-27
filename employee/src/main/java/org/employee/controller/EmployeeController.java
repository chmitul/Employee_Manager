package org.employee.controller;

import lombok.RequiredArgsConstructor;
import org.employee.dto.EmployeeDto;
import org.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employee")
public class EmployeeController
{
	private final EmployeeService employeeService;

	@PostMapping(value = "/add")
	public ResponseEntity<EmployeeDto> saveEmployee(
					@RequestBody EmployeeDto employee)
	{
		return ResponseEntity.ok().body(employeeService.addEmployee(employee));
	}

	@GetMapping(value = "/getall")
	public ResponseEntity<List<EmployeeDto>> listEmployees()
	{
		List<EmployeeDto> dtos = employeeService.findAllEmployees();
		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id)
	{
		EmployeeDto dto = employeeService.findById(id);
		if(dto != null)
		{
			return ResponseEntity.ok().body(dto);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(
					@PathVariable Integer id , @RequestBody EmployeeDto employee)
	{
		EmployeeDto dto = employeeService.findById(id);
		if(dto != null)
		{
			return ResponseEntity.ok()
							.body(employeeService.updateEmployee(id , employee));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
	{
		employeeService.deleteEmployeeById(id);
		return ResponseEntity.notFound().build();
	}
}
