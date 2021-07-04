package com.example.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entity.concrete.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
