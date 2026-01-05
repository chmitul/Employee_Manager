package org.manager.service;

import org.manager.dto.EmployeeDto;
import org.manager.dto.ManagerDto;

import java.util.List;

public interface ManagerService
{
	ManagerDto getManagerbyId(Integer id);

	List<ManagerDto> getAllManagers();

	ManagerDto getManagerbyEmail(String email);

	List<EmployeeDto> getAllEmployeesForManager(Integer id);
}
