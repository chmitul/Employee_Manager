package org.employee.service;

import org.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService
{
	EmployeeDto findById(Integer id);

	EmployeeDto addEmployee(EmployeeDto employee);

	EmployeeDto updateEmployee(Integer Id , EmployeeDto employee);

	void deleteEmployeeById(Integer id);

	List<EmployeeDto> findAllEmployees();
}
