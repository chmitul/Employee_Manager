package org.employee.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.employee.Exception.EmployeeNotFoundException;
import org.employee.dto.EmployeeDto;
import org.employee.entity.Employee;
import org.employee.mapper.EmployeeMapper;
import org.employee.repository.EmployeeRepository;
import org.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService
{
	private final EmployeeRepository employeeRepository;

	@Transactional(readOnly = true)
	@Override
	public EmployeeDto findById(Integer id)
	{
		log.info("Inside findById to find employee with id {}" , id);
		Employee emp = employeeRepository.findById(id)
						.orElseThrow(() -> new EmployeeNotFoundException("Employee with " + "id" + " " + id + " not found"));
		return EmployeeMapper.entityToDto(emp);
	}

	@Override
	@Transactional
	public EmployeeDto addEmployee(EmployeeDto employee)
	{
		log.info("Inside addEmployee to add employee {}" , employee);
		if(employee == null)
		{
			throw new IllegalArgumentException("Employee cannot be null");
		}
		Employee emp = EmployeeMapper.dtoToEntity(employee);
		employeeRepository.save(emp);
		log.info("Employee added successfully");
		return EmployeeMapper.entityToDto(emp);
	}

	@Override
	@Transactional
	public EmployeeDto updateEmployee(Integer id , EmployeeDto employee)
	{
		log.info("Inside updateEmployee to update employee {} with details {}" ,
						id , employee);
		Employee emp = employeeRepository.findById(id).orElseThrow(() ->
		{
			log.info("Employee with the given id {} is not found to update. " , id);
			return new EmployeeNotFoundException("Update failed as id is not " +
							"found " + ":" + " " + id);
		});
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setManagerId(employee.getManagerId());
		emp.setPhoneNumber(employee.getPhoneNumber());
		emp.setJoiningDate(employee.getJoiningDate());
		emp.setCity(employee.getCity());
		emp.setSalary(employee.getSalary());
		return EmployeeMapper.entityToDto(employeeRepository.save(emp));
	}

	@Override
	public void deleteEmployeeById(Integer id)
	{
		log.info("Inside deleteEmployeeById to delete employee with id {}" , id);
		if(!employeeRepository.existsById(id))
		{
			log.info("Employee not found with id {} to delete" , id);
			throw new EmployeeNotFoundException("Employee not found with id to" + " "
							+ "delete :  " + id);
		}
		employeeRepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<EmployeeDto> findAllEmployees()
	{
		log.info("Inside findAllEmployees to find all employees");
		//		List<Employee> employees = employeeRepository.findAll();
		//		List<EmployeeDto> dtos = new ArrayList<>();
		//		for(Employee employee : employees)
		//		{
		//			dtos.add(EmployeeMapper.entityToDto(employee));
		//		}
		//		return dtos;
		return employeeRepository.findAll().stream()
						.map(EmployeeMapper::entityToDto).toList();
	}

	@Override
	public List<EmployeeDto> findByCity(String city)
	{
		//		List<Employee> employeeListWithCity = employeeRepository.findAll()
		//		.stream()
		//						.filter(emp -> emp.getCity().equalsIgnoreCase(city))
		//						.toList();
		//		return employeeListWithCity.stream().map(EmployeeMapper::entityToDto)
		//						.toList();
		return employeeRepository.findAll().stream()
						.filter(emp -> emp.getCity().equalsIgnoreCase(city))
						.map(EmployeeMapper::entityToDto).toList();
	}

	@Override
	public List<String> getEarnersAboveAmount(BigDecimal salary)
	{
		List<String> list = new ArrayList<String>();
		list = employeeRepository.findAll().stream()
						.filter(emp -> emp.getSalary().compareTo(salary) > 0)
						.map(Employee::getFirstName).toList();
		return list;
	}

	@Override
	public Map<String, List<EmployeeDto>> groupEmployeeByCity()
	{
		return employeeRepository.findAll().stream()
						.filter(employee -> employee.getCity() != null)
						.map(EmployeeMapper::entityToDto)
						.collect(Collectors.groupingBy(EmployeeDto::getCity));
	}
}
