package org.employee.service.Impl;

import lombok.RequiredArgsConstructor;
import org.employee.dto.EmployeeDto;
import org.employee.entity.Employee;
import org.employee.mapper.EmployeeMapper;
import org.employee.repository.EmployeeRepository;
import org.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService
{
	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto findById(Integer id)
	{
		Employee emp = employeeRepository.findById(id).get();
		return EmployeeMapper.EntityToDto(emp);
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employee)
	{
		Employee emp = EmployeeMapper.DtoToEntity(employee);
		employeeRepository.save(emp);
		return EmployeeMapper.EntityToDto(emp);
	}

	@Override
	public EmployeeDto updateEmployee(Integer id , EmployeeDto employee)
	{
		Employee emp = employeeRepository.findById(id).get();
		if(emp != null)
		{
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setManagerId(employee.getManagerId());
			emp.setPhoneNumber(employee.getPhoneNumber());
			emp.setJoiningDate(employee.getJoiningDate());
			emp.setCity(employee.getCity());
			emp.setSalary(employee.getSalary());

		}
		return EmployeeMapper.EntityToDto(employeeRepository.save(emp));
	}

	@Override
	public void deleteEmployeeById(Integer id)
	{
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDto> findAllEmployees()
	{
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> dtos = new ArrayList<>();
		for(Employee employee : employees)
		{
			dtos.add(EmployeeMapper.EntityToDto(employee));
		}
		return dtos;
	}
}
