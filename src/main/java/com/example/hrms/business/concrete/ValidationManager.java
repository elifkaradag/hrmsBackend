package com.example.hrms.business.concrete;

import org.springframework.stereotype.Service;

import com.example.hrms.entity.abstracts.IEntity;
import com.sun.jdi.Field;

@Service
public class ValidationManager {


	public Object runGetter(IEntity aClass)
	{
		java.lang.reflect.Field[] fields = aClass.getClass().getFields();
		
		// MZ: Find the correct method
		for (java.lang.reflect.Field field : fields)
		{
			if(field.getName().endsWith("Name") && field != null){
				System.out.println(field);
				//ield.getType().equals("String") && 
			}
			
			System.out.println(field);
		}

		return null;
	}

}
