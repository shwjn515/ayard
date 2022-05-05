package com.test.ayard.Repositories;


import java.util.Optional;

import com.test.ayard.entities.UserInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Remove @RepositoryRestResource below to disable auto REST api:
@RepositoryRestResource
public interface UserRepository extends CrudRepository<UserInfo, Integer>{
    Optional<UserInfo> findById(Integer id);
}