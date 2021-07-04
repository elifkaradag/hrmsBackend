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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User implements IEntity{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="url")
	private String url;
	
	@Column(name="phone")
	private String phone;
	
	
	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private List<JobAdvertisement> jobAdvertisement;

}
