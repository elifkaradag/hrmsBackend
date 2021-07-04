package com.example.hrms.entity.concrete;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hrms.entity.abstracts.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@Column(name = "cover_letter")
	private String coverLetter;
	
    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
	private List<School> schools;
	
    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
	private List<ProgrammingLanguage> programmingLanguages;
	
    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<Language> languages;
	
    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<JobExperience> jobExperiences;
	
	

}
