package com.well.kept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Job {
	
	@Id
	@Column(length=25)
	private String name;
	private int numberOfStudents;
}
