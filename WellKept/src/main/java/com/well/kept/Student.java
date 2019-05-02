package com.well.kept;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private final Long Id;
	
	private String name;
	
	@ManyToOne(targetEntity=Job.class)
	private Job currentJob;
	
	@ManyToMany(targetEntity=Job.class)
	private List<Job> jobsThisCycle;
	
}
