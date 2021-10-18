package com.animesystem.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animesystem.controller.UserController;
import com.animesystem.controller.dto.UserDto;
import com.animesystem.controller.dto.UserLoginDto;
import com.animesystem.entity.UserDetail;
import com.animesystem.mapper.UserDetailMapper;
import com.animesystem.repository.UserRepository;
import com.animesystem.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
   
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Override
	public UserDto addUser(UserDto userDto) throws Exception {
		
		UserDetail userDetail=userDetailMapper.dtoToEntity(userDto);
		
		userDetail=userRepository.save(userDetail);
		
		return userDetailMapper.entityToDto(userDetail);
		
	}

	@Override
	public UserDto isUserPresent(UserLoginDto userLoginDto) throws Exception {
		
		UserDetail existingEntity=userRepository.findUserByEmail(userLoginDto.getEmail(),userLoginDto.getPassword());
		if(existingEntity==null) return null; 
		 
		UserDto userDto=userDetailMapper.entityToDto(existingEntity); 
		
	
		return userDto;
		
	}



}
