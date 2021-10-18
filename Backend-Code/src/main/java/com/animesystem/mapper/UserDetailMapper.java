package com.animesystem.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.animesystem.controller.dto.UserDto;
import com.animesystem.entity.UserDetail;

@Component
public class UserDetailMapper {
	
	public  UserDetail dtoToEntity(UserDto dto) {
		
		UserDetail entity=new UserDetail();
		entity.setId(UUID.randomUUID().toString());
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPassword(dto.getPassword());
		
		return entity;
	}
	
	
	public  UserDto entityToDto(UserDetail entity) {
		
		UserDto dto=new UserDto();
		
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setPassword(entity.getPassword());
	
		return dto;
	}

}
