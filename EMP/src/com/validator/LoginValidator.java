package com.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.formbean.LoginForm;
import com.service.LoginService;

//proerties file mapping 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

@Component
public class LoginValidator implements Validator
  {
	private Resource propertiesLocation;
    @Required
    public void setPropertiesLocation(Resource propertiesLocation) {
        this.propertiesLocation = propertiesLocation;
    }
	
		
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.isAssignableFrom(clazz);
	}

		
	@Override
	public void validate(Object target, Errors errors)
	 {
		try {
		Properties props = PropertiesLoaderUtils.loadProperties(propertiesLocation);
		System.out.println(" login validator class calling >>>>>>>>>>>>>>>>>");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","username.required",props.getProperty("username.required"));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.required",props.getProperty("password.required"));
		}
	 	catch (IOException e)
	    {
		e.printStackTrace();
	    }
	   }
       }
