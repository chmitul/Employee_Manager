package org.manager.mapper;

import org.manager.dto.ManagerDto;
import org.manager.entity.Manager;

public class ManagerMapper
{
	private ManagerMapper()
	{
	}

	public static ManagerDto entityToDto(Manager manager)
	{
		if(manager != null)
		{
			ManagerDto managerDto = new ManagerDto();
			managerDto.setId(manager.getId());
			managerDto.setName(manager.getName());
			managerDto.setEmail(manager.getEmail());
			managerDto.setPhoneNumber(manager.getPhoneNumber());
			return managerDto;
		}
		return null;
	}

	public static Manager dtoToEntity(Manager managerDto)
	{
		if(managerDto != null)
		{
			Manager manager = new Manager();
			manager.setId(managerDto.getId());
			manager.setName(managerDto.getName());
			manager.setEmail(managerDto.getEmail());
			manager.setPhoneNumber(managerDto.getPhoneNumber());
			return manager;
		}
		return null;
	}
}
