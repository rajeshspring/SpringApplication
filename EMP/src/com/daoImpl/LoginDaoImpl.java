package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.LoginDao;
import com.pojo.Employee;
import com.pojo.LoginBean;

public class LoginDaoImpl implements LoginDao
   {
	@Autowired
	SessionFactory sessionFactory;
	
	public LoginBean login(LoginBean loginBean)
	{
	Session session = null;
	LoginBean login=new LoginBean();
	List<LoginBean> loginBean1=new ArrayList<LoginBean>();
	try {
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(LoginBean.class);
		criteria.add(Restrictions.eq("username", loginBean.getUsername()));
		criteria.add(Restrictions.eq("password", loginBean.getPassword()));
		loginBean1=criteria.list();
		if(loginBean1.size()>0)
		{
	    		
	  for(LoginBean login1:loginBean1)
		{
		login.setUsername(login1.getUsername());
		login.setPassword(login1.getPassword());
		}
		} 
	    }
	catch (Exception e) 
		{
		e.printStackTrace();
		}

	finally
	{
	session.close();
	}
	return login;
	}

}
