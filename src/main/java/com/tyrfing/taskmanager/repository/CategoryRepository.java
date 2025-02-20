package com.tyrfing.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tyrfing.taskmanager.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
