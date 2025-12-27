package org.employee.mapper;

import org.employee.dto.EmployeeDto;
import org.employee.entity.Employee;

public class EmployeeMapper
{
	private EmployeeMapper()
	{
	}

	public static EmployeeDto EntityToDto(Employee emp)
	{
		EmployeeDto empDto = new EmployeeDto();
		empDto.setId(emp.getId());
		empDto.setFirstName(emp.getFirstName());
		empDto.setLastName(emp.getLastName());
		empDto.setSalary(emp.getSalary());
		empDto.setCity(emp.getCity());
		empDto.setPhoneNumber(emp.getPhoneNumber());
		empDto.setJoiningDate(emp.getJoiningDate());
		empDto.setManagerId(emp.getManagerId());
		return empDto;
	}

	public static Employee DtoToEntity(EmployeeDto empDto)
	{
		Employee emp = new Employee();
		emp.setId(empDto.getId());
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
		emp.setSalary(empDto.getSalary());
		emp.setCity(empDto.getCity());
		emp.setPhoneNumber(empDto.getPhoneNumber());
		emp.setJoiningDate(empDto.getJoiningDate());
		emp.setManagerId(empDto.getManagerId());
		return emp;
	}
}
