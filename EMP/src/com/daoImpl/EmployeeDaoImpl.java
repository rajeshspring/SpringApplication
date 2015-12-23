package com.daoImpl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.EmployeeDao;
import com.formbean.EmployeeForm;
import com.master.pojo.State;
import com.pojo.Employee;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryBuilder;

public class EmployeeDaoImpl implements EmployeeDao
{
private static final Class employeed = null;
@Autowired
SessionFactory sessionFactory;	
DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
@Override
public boolean addEmpDetails(EmployeeForm userForm) 
{
// TODO Auto-generated method stub
	Session session = null;
	Transaction tx = null;
	try
	{
	session = sessionFactory.openSession();
	tx=session.beginTransaction();	
	Employee employee=new Employee();
	if(userForm.getEmpId()!=null && userForm.getEmpId()!="")
	{
	System.out.println(">>>>>>>>>>>> update block");
	Employee employee1=new Employee();
	employee1.setEmpId(Long.parseLong(userForm.getEmpId()));
	Employee employeeLocal=(Employee)session.get(Employee.class,employee1.getEmpId());
	
	employeeLocal.setEmpId(Long.parseLong(userForm.getEmpId()));
	employeeLocal.setAddress(userForm.getAddress());
	employeeLocal.setDate_of_birth(df.parse(userForm.getDate_of_birth()));
	employeeLocal.setName(userForm.getName());
	employeeLocal.setPhone(userForm.getPhone());
	employeeLocal.setEducation(userForm.getEducation());
	employeeLocal.setEmail(userForm.getEmail());
	employeeLocal.setEmployeeType(userForm.getEmployeeType());
	employeeLocal.setLastname(userForm.getLastname());
	employeeLocal.setOfficeaddress(userForm.getOfficeaddress());
	employeeLocal.setOfficedistrict(userForm.getOfficedistrict());
	employeeLocal.setOfficePinCode(userForm.getOfficePinCode());
	employeeLocal.setOfficestate(userForm.getOfficestate());
	employeeLocal.setParentdistrict(userForm.getParentdistrict());
	employeeLocal.setParentstate(userForm.getParentstate());
	employeeLocal.setParnetPinCode(userForm.getParnetPinCode());
	employeeLocal.setProfile(userForm.getProfile());
	employeeLocal.setDateofjoin(df.parse(userForm.getDateofjoin()));
	employeeLocal.setDateofleave(df.parse(userForm.getDateofleave()));
	session.saveOrUpdate(employeeLocal);
	tx.commit();
	return true;
	}
	else
	{
	System.out.println(" Employee Add block >>>>>>>>>>@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	employee.setAddress(userForm.getAddress());
	employee.setDate_of_birth(df.parse(userForm.getDate_of_birth()));
	employee.setName(userForm.getName());
	employee.setPhone(userForm.getPhone());
	employee.setEducation(userForm.getEducation());
	employee.setEmail(userForm.getEmail());
	employee.setEmployeeType(userForm.getEmployeeType());
	employee.setLastname(userForm.getLastname());
	employee.setOfficeaddress(userForm.getOfficeaddress());
	employee.setOfficedistrict(userForm.getOfficedistrict());
	employee.setOfficePinCode(userForm.getOfficePinCode());
	employee.setOfficestate(userForm.getOfficestate());
	employee.setParentdistrict(userForm.getParentdistrict());
	employee.setParentstate(userForm.getParentstate());
	employee.setParnetPinCode(userForm.getParnetPinCode());
	employee.setProfile(userForm.getProfile());
	employee.setDateofjoin(df.parse(userForm.getDateofjoin()));
	employee.setDateofleave(df.parse(userForm.getDateofleave()));
	
		session.saveOrUpdate(employee);
		tx.commit();
		 
		}
	    }
	catch (Exception e)
		{
		e.printStackTrace();
		//tx.rollback();
		return false;
		}

	finally
	{
	session.close();
    }
	return true;
	}

//Get Employee All Records
@Override
public List<Employee> getAllRecords(String page)
{
// TODO Auto-generated method stub
	      Session session = null;
	      Transaction tx = null;
	      List<Employee> employeeList=null;
	      try {
		    session = sessionFactory.openSession();
		    tx=session.beginTransaction();
		   //for by default and Last page  
			if(page==null)
			{
			System.out.println(">>>>> by default call on load"+page);
			Query query = session.createQuery("from Employee ORDER BY emp_id  desc LIMIT 20");	
			query.setMaxResults(20);
			employeeList = query.list();
			System.out.println(">>>>> by employeeList"+employeeList.size());
		    if(employeeList.size()==0)
			{
			return null;
			}	
		    else
		    {
		    return employeeList;
		    }
		   	}
		  
		  
		  //For First page 
		  if(page.equalsIgnoreCase("First"))
		    {
		    Criteria criteria = session.createCriteria(Employee.class);
		    System.out.println(">>>>>>>>>>>> First");
		  	criteria.setFirstResult(1);
			criteria.setMaxResults(10);
			employeeList = criteria.list();
		    if(employeeList.size()==0)
			{
			return null;
			}	
		    else
		    {
		    return employeeList;
		    }	
			}
		    
		  
		    if(page.equalsIgnoreCase("Last"))
		    {
		    System.out.println(">>>>>>>>>>>> Last ");
		    Query query = session.createQuery("from Employee ORDER BY emp_id  desc LIMIT 10");	
			query.setMaxResults(10);	
			employeeList = query.list();
			 if(employeeList.size()==0)
				{
				return null;
				}	
			    else
			    {
			    return employeeList;
			    }	
		        }
		  else
		 {
		Query query = session.createQuery("from Employee");
		int pageSize=10;
		query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
        query.setMaxResults(pageSize);
        employeeList = query.list();
        if(employeeList.size()==0)
		{
		return null;
		}
       	}
		}
	
	catch (Exception e) 
		{
		return null;
		}

	 finally
	   {
		session.close();
		//tx.commit();
	   }
	   return employeeList;
       }

@Override
public List<Employee> employeeView(Employee employee) {
	// TODO Auto-generated method stub
	 Session session = null;
	 Transaction tx = null;
     List<Employee> employeeList=null;
     
         try
         {
        	session=sessionFactory.openSession();
        	tx=session.beginTransaction();
    	    //Criteria criteria = session.createCriteria(Employee.class);
        	Query query = session.createQuery("from Employee where emp_id="+employee.getEmpId());	
			employeeList = query.list();
			System.out.println(">>>>>>>>>>>> employeeList"+employeeList.size());
		    if(employeeList.size()==0)
			{
			return null;
			}	
		    else
		    {
		    return employeeList;
		    }
            }
     
     catch(Exception e)
     {
     e.printStackTrace(); 
     }
     finally
     {
     session.close();
     //tx.commit();
     }
     return employeeList;
	 }

@Override
public Employee employeeViewDetails(Employee employee) {
	// TODO Auto-generated method stub
	Session session=null;
	Transaction tx = null;
	List<Employee> employeedetails=null;
	Employee employee1=new Employee();
	
	try
	{
		session=sessionFactory.openSession();
    	tx=session.beginTransaction();
	    //Criteria criteria = session.createCriteria(Employee.class);
    	Query query = session.createQuery("from Employee where emp_id="+employee.getEmpId());	
    	employeedetails = query.list();
    	for(Employee list:employeedetails)
    	   {
    		employee1.setEmpId(list.getEmpId());
    		employee1.setAddress(list.getAddress());
    		employee1.setDate_of_birth(list.getDate_of_birth());
    		employee1.setDateofjoin(list.getDate_of_birth());
    		employee1.setDateofleave(list.getDateofleave());
    		employee1.setEducation(list.getEducation());
    		employee1.setEmail(list.getEmail());
    		employee1.setEmployeeType(list.getEmployeeType());
    		employee1.setLastname(list.getLastname());
    		employee1.setName(list.getName());
    		employee1.setOfficeaddress(list.getOfficeaddress());
    		
    	  }
		System.out.println(">>>>>>>>>>>> employeeList"+employeedetails.size());
	    
	   }
	catch(Exception e)
	{
	}
	finally
	{
	}
	return employee1;
    }


/*  Employee Deleted */
@Override
public boolean employeeDelete(Employee employee)
  {
	// TODO Auto-generated method stub
	Session session=null;
	Transaction tx=null;
	try
	{
	session=sessionFactory.openSession();
	tx=session.beginTransaction();
	Employee employee1=(Employee)session.get(Employee.class,employee.getEmpId());
	session.delete(employee1);
    tx.commit();
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	
	finally
	{
	session.close();
	}
	return true;
    }

@Override
public EmployeeForm updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
	EmployeeForm employeeForm=new EmployeeForm();
	Session session=null;
	Transaction tx=null;
	
	try
	{
	 session=sessionFactory.openSession();
	 tx=session.beginTransaction();
	 if(employee.getEmpId()!=null)
	 {
	 Employee employeelocal=(Employee)session.get(Employee.class,employee.getEmpId());
	 employeeForm.setAddress(employeelocal.getAddress());
	 DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	 
	 System.out.println(">>>>>>>>>>>>> Date fromat @@@@@@@@@@@@@@@ getDate_of_birth()"+employeelocal.getDate_of_birth());
	 System.out.println(">>>>>>>>>>>>> Date fromat @@@@@@@@@@@@@@@ getDateofjoin()"+df.format(employeelocal.getDateofjoin()));
	 
	 employeeForm.setDate_of_birth(df.format(employeelocal.getDate_of_birth()));
	 employeeForm.setDateofjoin(df.format(employeelocal.getDateofjoin()));
	 employeeForm.setDateofleave(df.format(employeelocal.getDateofleave()));
	 employeeForm.setEducation(employeelocal.getEducation());
	 employeeForm.setEmail(employeelocal.getEmail());
	 employeeForm.setEmployeeType(employeelocal.getEmployeeType());
	 employeeForm.setLastname(employeelocal.getLastname());
	 employeeForm.setName(employeelocal.getName());
	 employeeForm.setOfficeaddress(employeelocal.getOfficeaddress());
	 employeeForm.setOfficePinCode(employeelocal.getOfficePinCode());
	 employeeForm.setParnetPinCode(employeelocal.getParnetPinCode());
	 employeeForm.setPhone(employeelocal.getPhone());
	 employeeForm.setProfile(employeelocal.getProfile());
	 
	 employeeForm.setParentstate(employeelocal.getParentstate());
	 employeeForm.setOfficestate(employeelocal.getOfficestate());
	 
	 employeeForm.setParentdistrict(employeelocal.getParentdistrict());
	 employeeForm.setOfficedistrict(employeelocal.getOfficedistrict());
	 employeeForm.setEmpId(Long.toString(employeelocal.getEmpId()));
	 
	tx.commit();
	return employeeForm;
	 }
     }
	catch(Exception e)
	{
	
	}
	finally
	{
	session.close();
	}
	return employeeForm;
	}

/* Get parent state name */
@Override
public State getParentSateName(State state) 
{
	// TODO Auto-generated method stub
	Session session=null;
	Transaction tx=null;
	try
	{
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		State state1=(State)session.get(State.class,state.getState_id());
		state.setState_id(state1.getState_id());
		state.setStatename(state1.getStatename());
		tx.commit();
		return state;
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	finally
	{
		session.close();
	}
	return state;
}

@Override
public State getOfficeSateName(State state) {
	// TODO Auto-generated method stub
	Session session=null;
	Transaction tx=null;
	try
	{
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		State state1=(State)session.get(State.class,state.getState_id());
		state.setState_id(state1.getState_id());
		state.setStatename(state1.getStatename());
		tx.commit();
		return state;
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	finally
	{
		session.close();
	}
	return state;
}

/* Jasper report */
@Override
public List<Employee> employeeDetailsWithJasper(Employee employee) {
	// TODO Auto-generated method stub
	Session session=null;
	Transaction tx=null;
	List<Employee> emp=null;
	
	  try
	   {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		 Query query = session.createQuery("from Employee ORDER BY emp_id  desc");
		 emp=query.list();
		 for(Employee aa: emp)
		 {
			 System.out.println(">>>>>>>>>>>>> ################# Employee"+aa.getName());
		 }
		 tx.commit();
		 
	    }
	
	  catch(Exception e)
	   {
		e.printStackTrace();
		return null;
	   }
	
	   finally
	   {
		session.close();
	   }
	
	   return emp;
      } 
      }
