package com.tyrfing.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tyrfing.taskmanager.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
