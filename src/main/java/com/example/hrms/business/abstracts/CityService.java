package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entity.concrete.City;

public interface CityService {
	
	DataResult<List<City>> getAll();
    DataResult<City> add(City city);

}
