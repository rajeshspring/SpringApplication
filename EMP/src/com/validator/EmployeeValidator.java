package com.validator;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formbean.LoginForm;
import com.formbean.EmployeeForm;
import com.pojo.Employee;

@Component
public class EmployeeValidator implements Validator
{
	   

	private Resource propertiesLocation;
    @Required
    public void setPropertiesLocation(Resource propertiesLocation) {
        this.propertiesLocation = propertiesLocation;
    }
	
		
	@Override
	public boolean supports(Class<?> clazz) {
		return EmployeeForm.class.isAssignableFrom(clazz);
	}


	@Override
	public void validate(Object obj, Errors errors)
	{
		try {
			Properties props = PropertiesLoaderUtils.loadProperties(propertiesLocation);
			EmployeeForm userform=(EmployeeForm)obj;
			System.out.println(" Employee Validator class calling >>>>>>>>>>>>>>>>>");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","name.required",props.getProperty("name.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname","lastname.required",props.getProperty("lastname.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "education","education.required",props.getProperty("education.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profile","profile.required",props.getProperty("profile.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","email.required",props.getProperty("email.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeType","employeeType.required",props.getProperty("employeeType.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone","phone.required",props.getProperty("phone.required"));
		
			if(userform.getDateofjoin()==null)
			{
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateofjoin_error","dateofjoin.required",props.getProperty("dateofjoin.required"));	
			}
			if(userform.getDateofleave()==null)
			{
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateofleave_error","dateofleave.required",props.getProperty("dateofleave.required"));
			}
		    if(userform.getDate_of_birth()==null)
			{
		    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date_of_birth_error","date_of_birth.required",props.getProperty("date_of_birth.required"));
			System.out.println(">>>>>>>>>>>>>> check date of birth #####"+userform.getDate_of_birth());
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address","address.required",props.getProperty("address.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parentstate","parentstate.required",props.getProperty("parentstate.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parentdistrict","parentdistrict.required",props.getProperty("parentdistrict.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parnetPinCode","parnetPinCode.required",props.getProperty("parnetPinCode.required"));
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeaddress","officeaddress.required",props.getProperty("officeaddress.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officestate","officestate.required",props.getProperty("officestate.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officedistrict","officedistric.required",props.getProperty("officedistric.required"));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officePinCode","officePinCode.required",props.getProperty("officePinCode.required"));
			System.out.println("Employee form validation is over>>>>>>>>>>>>>>>>>>>>111111111");
			
			}
		 	catch (IOException e)
		    {
			e.printStackTrace();
		    }
		
	}

	
	 

}
