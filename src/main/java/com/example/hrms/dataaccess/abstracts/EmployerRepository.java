package com.example.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entity.concrete.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{
	List<Employer> findByEmail(String email);

}
