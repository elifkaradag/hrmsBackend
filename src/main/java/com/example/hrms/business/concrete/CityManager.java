package com.example.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataaccess.abstracts.CityRepository;
import com.example.hrms.entity.concrete.City;
import com.example.hrms.entity.concrete.School;

@Service
public class CityManager implements CityService{
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(this.cityRepository.findAll());
    }

    @Override
    public DataResult<City> add(City city) {
        return new SuccessDataResult<City>(this.cityRepository.save(city),"City added!!");
    }


}
