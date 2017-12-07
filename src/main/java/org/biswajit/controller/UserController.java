package org.biswajit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.biswajit.data.entities.User;
import org.biswajit.data.entities.UserDto;
import org.biswajit.service.UserService;
import org.biswajit.validator.RestValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestValidator userValidator;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET ,
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List<User> getUserList(){
		return userService.getUserList();
	}
	
	@GetMapping(value="/{userId}",
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody UserDto getUser(@PathVariable("userId") int userId,HttpServletResponse response){
		User user= userService.getUserById(userId);
		if( user != null){
			ModelMapper mapper=new ModelMapper();
			UserDto userDto=mapper.map(user, UserDto.class);
			response.setStatus(HttpServletResponse.SC_OK);
			return userDto;
		}else{
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return new UserDto();
		}
		
		
	}
	
	@PostMapping(value="/add" ,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody User add(@Valid @RequestBody User user ,Errors errors  ,HttpServletResponse response){
		System.out.println(user);
		if(errors.hasErrors()){
			System.out.println("there is error");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return new User();
		}else{
			userService.saveOrUpdateUser(user);
			response.setStatus(HttpServletResponse.SC_CREATED);
			return user;
		}
		
	
	}
	
	@PutMapping(value="/update/{userId}",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody User update(@PathVariable("userId") int userId ,@RequestBody User user){
		user.setUserId(userId);
		userService.saveOrUpdateUser(user);
		return user;
	}
	
	@DeleteMapping(value="/delete/{userId}",consumes=MediaType.APPLICATION_JSON_VALUE,	
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public @ResponseBody User deleteUSer(@PathVariable("userId") int userId){
		User user=userService.getUserById(userId);
		userService.deleteUser(userId);
		return user;
	}
	
	
	  @InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(userValidator);
	    }
	
	
}
