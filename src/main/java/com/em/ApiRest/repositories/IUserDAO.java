package com.em.ApiRest.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.em.ApiRest.models.UserDTO;

@Repository
public interface IUserDAO extends MongoRepository<UserDTO, String>{

}
