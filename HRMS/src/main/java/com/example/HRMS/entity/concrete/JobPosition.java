package com.example.HRMS.entity.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.HRMS.entity.abstracts.IEntity;

import lombok.Data;

@Entity
@Table(name ="job_positions")
@Data
public class JobPosition implements IEntity{

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="position_name")
	private String name;

	public JobPosition() {}

	public JobPosition(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



}
