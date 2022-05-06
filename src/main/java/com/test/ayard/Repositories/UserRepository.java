package com.test.ayard.Repositories;


import java.util.Optional;

import com.test.ayard.entities.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author 86156
 */ //Remove @RepositoryRestResource below to disable auto REST api:
@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {
    @Query(value = "select * from userinfo where id = ?1 ;", nativeQuery = true)
    Optional<UserInfo> findByuid(Long id);
    @Query(value = "select * from userinfo where phone = ?1 ;", nativeQuery = true)
    Optional<UserInfo> findByuphone(Long phone);
    @Query(value = "select count(*) from userinfo;", nativeQuery = true)
    int getSize();
}