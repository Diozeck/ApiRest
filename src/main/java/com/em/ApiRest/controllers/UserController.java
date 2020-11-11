package com.em.ApiRest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.em.ApiRest.models.UserDTO;
import com.em.ApiRest.repositories.IUserDAO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/usuarios")
public class UserController {

	@Autowired
	private IUserDAO repo;
	
	@PostMapping
	public UserDTO create(@Validated @RequestBody UserDTO u ) {
		return repo.insert(u);
	}

	@GetMapping
	public List<UserDTO> readall(){
		return repo.findAll();
	}
	
	@PutMapping(path = {"/{id}"})
    public UserDTO editar(@RequestBody UserDTO u,@PathVariable("id") String id){
        u.set_id(id);
        return repo.save(u);
    }
	
	
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id") String id){
        repo.deleteById(id);
    }
	
	
	@GetMapping(path = {"/{id}"})
    public Optional<UserDTO> listarId(@PathVariable("id") String id){
        return repo.findById(id);
    }
	
}
