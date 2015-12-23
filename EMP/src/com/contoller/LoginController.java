package com.contoller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formbean.LoginForm;
import com.formbean.EmployeeForm;
import com.pojo.LoginBean;
import com.service.LoginService;
import com.validator.LoginValidator;

@Controller
public class LoginController
	{
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired(required=true)
	LoginService loginServices;
	
	@Autowired(required=true)
	LoginValidator loginValidator;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
	binder.setValidator(loginValidator);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String userlogin(LoginForm loginForm,Model model,HttpSession session,HttpServletRequest request,Locale locale)
	{
		System.out.println("######### user login ################");
		logger.info("This is an info log entry >>>>>>>>>>>>>>>>>>>>>>>>");
        logger.error("This is an error log entry >>>>>>>>>>>>>>>>>>>>>>>>>");
		logger.debug("This is an info login entry 0000000000000000000000000");
        logger.error("This is an error login entry 111111111111111111111111");
        logger.debug("Test Login >>>>>>>>>>>>>>>>>>>>>> messqage!");
                
	 return "userlogin";
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute @Valid LoginForm loginForm,BindingResult result,Model model,Locale locale)
	   {
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		   try
		   {
		    loginValidator.validate(loginForm, result);
		    {
			if(result.hasErrors())
			{
			System.out.println("Errrrrrrrrrrrr");
			return "userlogin";
			}
			
			else
			{
			System.out.println("successsssssssssssss"+loginForm.getUsername());
			LoginBean loginBean=new LoginBean();
			loginBean.setUsername(loginForm.getUsername());
			loginBean.setPassword(loginForm.getPassword());
			loginBean=loginServices.login(loginBean);
			logger.error("Test error message");
			if(loginBean!=null)	
			if(loginBean.getUsername().equals(loginForm.getUsername()) || loginBean.getPassword().equals(loginForm.getPassword()))
			{
			return "login";
			}
			}
		    }
		    }
		
		    catch(Exception e)
		    {
			logger.error("Test error message login fail ", new Exception("Test error message login fail"));
		    }
		    model.addAttribute("loginFailed","Invalid username and password");	
		    return "userlogin";
	         }
	         }
