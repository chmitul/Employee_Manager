package org.manager.service.ServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.manager.dto.ManagerDto;
import org.manager.entity.Manager;
import org.manager.mapper.ManagerMapper;
import org.manager.repository.ManagerRepository;
import org.manager.service.ManagerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerServiceImpl implements ManagerService
{
	private final ManagerRepository managerRepository;

	@Override
	public ManagerDto getManagerbyId(Integer id)
	{
		Manager managerDetails = managerRepository.findById(id).get();
		if(managerDetails != null)
		{
			return ManagerMapper.entityToDto(managerDetails);
		}
		return null;
	}

	@Override
	public List<ManagerDto> getAllManagers()
	{
		List<Manager> managers = managerRepository.findAll();
		List<ManagerDto> managerDtos = new ArrayList<ManagerDto>();
		if(managers != null)
		{
			for(Manager manager : managers)
			{
				managerDtos.add(ManagerMapper.entityToDto(manager));
			}
		}
		return managerDtos;
	}

	@Override
	public ManagerDto getManagerbyEmail(String email)
	{
		Manager managerByEmail = managerRepository.findByEmail(email) ;
		return ManagerMapper.entityToDto(managerByEmail);
	}
}
