package org.employee.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.employee.dto.EmployeeDto;
import org.employee.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employee")
public class EmployeeController
{
	private final EmployeeService employeeService;

	@PostMapping(value = "/add")
	public ResponseEntity<EmployeeDto> saveEmployee(
					@Valid @RequestBody EmployeeDto employee)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
						.body(employeeService.addEmployee(employee));
	}

	@GetMapping(value = "/getall")
	public ResponseEntity<List<EmployeeDto>> listEmployees()
	{
		return ResponseEntity.ok().body(employeeService.findAllEmployees());
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(
					@PathVariable @Positive Integer id)
	{
		return ResponseEntity.ok().body(employeeService.findById(id));
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(
					@PathVariable Integer id , @Valid @RequestBody EmployeeDto employee)
	{
		return ResponseEntity.ok()
						.body(employeeService.updateEmployee(id , employee));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteEmployee(
					@PathVariable @Positive Integer id)
	{
		employeeService.deleteEmployeeById(id);
		return ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/bycity/{city}")
	public ResponseEntity<List<EmployeeDto>> findByCity(@PathVariable String city)
	{
		return ResponseEntity.ok().body(employeeService.findByCity(city));
	}

	@GetMapping(value = "/earningabove/{salary}")
	public ResponseEntity<List<String>> getHighEarners(
					@PathVariable BigDecimal salary)
	{
		return ResponseEntity.ok(employeeService.getEarnersAboveAmount(salary));
	}

	@GetMapping(value = "/groupbycity")
	public ResponseEntity<Map<String, List<EmployeeDto>>> getGroupByCity()
	{
		return ResponseEntity.ok(employeeService.groupEmployeeByCity());
	}

	@GetMapping(value = "/getbyphonenumber/{phoneNumber}")
	public ResponseEntity<EmployeeDto> getEmployeeByPhoneNumber(
					@PathVariable Long phoneNumber)
	{
		return ResponseEntity.ok(employeeService.getEmployeeByPhoneNumber(phoneNumber));
	}

	@GetMapping(value = "/getbylastname/{lastName}")
	public ResponseEntity<EmployeeDto> getEmployeeByLastName(
					@PathVariable String lastName)
	{
		return ResponseEntity.ok(employeeService.getEmployeeByLastName(lastName));
	}

	@GetMapping(value = "/getallbypagination")
	public ResponseEntity<Page<EmployeeDto>> getEmployeeByPagination(
					@RequestParam(defaultValue = "0") int page ,
					@RequestParam(defaultValue = "5") int size)
	{
		Pageable pageable = PageRequest.of(page , size);
		return ResponseEntity.ok(employeeService.getAllByPagination(pageable));
		//TODO - write a exmaple for pagination sorting
	}
}
