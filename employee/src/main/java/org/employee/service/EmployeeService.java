package org.employee.service;

import org.employee.dto.EmployeeDto;
import org.employee.entity.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface EmployeeService
{
	EmployeeDto findById(Integer id);

	EmployeeDto addEmployee(EmployeeDto employee);

	EmployeeDto updateEmployee(Integer Id , EmployeeDto employee);

	void deleteEmployeeById(Integer id);

	List<EmployeeDto> findAllEmployees();

	List<EmployeeDto> findByCity(String city);

	List<String> getEarnersAboveAmount(BigDecimal salary);

	Map<String, List<EmployeeDto>> groupEmployeeByCity();
}
