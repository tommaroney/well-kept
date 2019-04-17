package com.well.kept.data;

import org.springframework.data.repository.CrudRepository;

import com.well.kept.Job;

public interface JobRepository extends CrudRepository<Job, String> {

}
