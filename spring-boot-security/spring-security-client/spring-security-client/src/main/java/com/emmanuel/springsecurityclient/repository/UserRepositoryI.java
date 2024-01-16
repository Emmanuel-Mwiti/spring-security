package com.emmanuel.springsecurityclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.springsecurityclient.entity.User;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {

}
