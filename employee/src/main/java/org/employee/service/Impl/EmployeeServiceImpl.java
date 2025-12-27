package org.employee.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class EmployeeServiceImpl implements EmployeeService
{
	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto findById(Integer id)
	{
		log.info("Inside findById to find employee with id {}" , id);
		Employee emp = employeeRepository.findById(id).get();
		if(emp != null)
		{
			log.info("Employee found with id {}" , id);
			return EmployeeMapper.EntityToDto(emp);
		}
		else
		{
			log.info("Employee not found with id {}" , id);
			return null;
		}
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employee)
	{
		log.info("Inside addEmployee to add employee {}" , employee);
		Employee emp = EmployeeMapper.DtoToEntity(employee);
		if(emp != null)
		{
			employeeRepository.save(emp);
			log.info("Employee added successfully");
			return EmployeeMapper.EntityToDto(emp);
		}
		else
		{
			log.info("Employee not added successfully");
			return null;
		}
	}

	@Override
	public EmployeeDto updateEmployee(Integer id , EmployeeDto employee)
	{
		log.info("Inside updateEmployee to update employee {} with details {}" ,
						id , employee);
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
			return EmployeeMapper.EntityToDto(employeeRepository.save(emp));
		}
		else
		{
			log.info("Employee not found with id {}" , id);
			return null;
		}
	}

	@Override
	public void deleteEmployeeById(Integer id)
	{
		log.info("Inside deleteEmployeeById to delete employee with id {}" , id);
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDto> findAllEmployees()
	{
		log.info("Inside findAllEmployees to find all employees");
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> dtos = new ArrayList<>();
		for(Employee employee : employees)
		{
			dtos.add(EmployeeMapper.EntityToDto(employee));
		}
		return dtos;
	}
}
