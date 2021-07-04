package com.example.hrms.entity.concrete;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hrms.entity.abstracts.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement implements IEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int advertId;
	
	@Column(name="job_definitation")
	private String jobDefinitation;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="quota")
	private int quota;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column(name = "is_active")
	private boolean isActive;
	
    @NotNull
	@ManyToOne()
	@JoinColumn(name = "title_id")
	private JobTitle jobtitle;
	
    @NotNull
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
    @NotNull
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	

}
