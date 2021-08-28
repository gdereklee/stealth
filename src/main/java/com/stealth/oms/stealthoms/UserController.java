package com.stealth.oms.stealthoms;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.stealth.oms.model.User;
import com.stealth.oms.model.UserLimits;

@RestController
@EntityScan("com.stealth.oms.model")
public class UserController {
	//@Autowired 
	//private UserDaoService service;	
	@Autowired
	private Configuration configuration;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		//return service.findAll();
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping(value="/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;		
	}	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {		
		userRepository.deleteById(id);		
	}	
	
	@GetMapping("UserLimits")
	public UserLimits retrieveUserLimit() {
		return new UserLimits(configuration.getMaximum(), configuration.getMinimum());
	}
	/*
	public MappingJacksonValue retrieveAllUsers() {
		List<User> users = service.findAll();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("accountNumber");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(users);
		mapping.setFilters(filters);
		return mapping;
	}
	*/
	/*
	@GetMapping(value="/users/{id}", headers="X-API-VERSION=1")
	public EntityModel<User> retrieveUserV1(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;		
	}
	*/
/*
	@GetMapping(value="/users/{id}", headers="X-API-VERSION=2")
	public EntityModel<User> retrieveUserV2(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;		
	}
	*/
	/*
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {		
		User newUser = service.create(user);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {		
		User user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
	*/
}
