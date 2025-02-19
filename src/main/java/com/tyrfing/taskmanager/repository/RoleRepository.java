package com.tyrfing.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tyrfing.taskmanager.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
