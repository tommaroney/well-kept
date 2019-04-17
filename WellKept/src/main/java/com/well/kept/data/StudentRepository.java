package com.well.kept.data;

import org.springframework.data.repository.CrudRepository;

import com.well.kept.Student;

public interface StudentRepository extends CrudRepository<Student, String>{

}
