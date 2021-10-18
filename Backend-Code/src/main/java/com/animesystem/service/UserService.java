package com.animesystem.service;

import com.animesystem.controller.dto.UserDto;
import com.animesystem.controller.dto.UserLoginDto;

public interface UserService {
	public UserDto addUser(UserDto userDto) throws Exception;
	public UserDto isUserPresent(UserLoginDto userLoginDto) throws Exception;
}
