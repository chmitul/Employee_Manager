package org.employee.service;

import org.employee.dto.EmployeeDto;
import org.employee.dto.ManagerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

	EmployeeDto getEmployeeByPhoneNumber(Long phoneNumber);

	EmployeeDto getEmployeeByLastName(String lastName);

	Page<EmployeeDto> getAllByPagination(Pageable pageable);

	ManagerDto getManagerDetails(Integer employeeId);

	List<EmployeeDto> getEmployeeByManagerId(Integer managerId);
}
