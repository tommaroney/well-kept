package com.well.kept.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.well.kept.Classroom;
import com.well.kept.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
