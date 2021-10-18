package com.animesystem.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animesystem.controller.dto.UserDto;
import com.animesystem.controller.dto.UserLoginDto;
import com.animesystem.serviceimpl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
		try {
			UserDto saveDto = userServiceImpl.addUser(userDto);
			if (saveDto == null) {
				return new ResponseEntity<>("Server Unaailable", HttpStatus.SERVICE_UNAVAILABLE);
			}
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error Occured in User Controller while Registering...");
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserLoginDto userLoginDto) {
		try {
			
			LOGGER.info("@@@@@@@Login: "+userLoginDto.getEmail());
			
			UserDto userDto=userServiceImpl.isUserPresent(userLoginDto);
			if(userDto!=null) {
			
				return new ResponseEntity<>(userDto,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);	
			}
		
		} catch (Exception e) {
			LOGGER.error("Error Occured in User Controller while Login...");
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
