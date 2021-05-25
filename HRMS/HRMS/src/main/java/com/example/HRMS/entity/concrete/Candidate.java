package com.example.HRMS.entity.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import com.example.HRMS.entity.abstracts.IEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User implements IEntity{
	
	@Column(name="identity")
	private String identity;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="year_of_birth")
	private String yearOfBirth;
	
	

}
