package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.EmployeeDao;
import com.pojo.LoginBean;
import com.service.LoginService;
import com.dao.LoginDao;

public class LoginServiceImpl implements LoginService 
{
	@Autowired(required=true)
	LoginDao loginDAO;
	
	@Override
	public LoginBean login(LoginBean loginBean) {
		// TODO Auto-generated method stub
		
		return loginDAO.login(loginBean);
	  }

}
