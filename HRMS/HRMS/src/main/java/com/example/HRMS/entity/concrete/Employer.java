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

}
