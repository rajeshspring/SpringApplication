package com.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.MasterServiceDao;
import com.master.pojo.District;
import com.master.pojo.State;
import com.pojo.Employee;
import com.pojo.Manager;

public class MasterServiceDaoImpl implements MasterServiceDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<State> getStateName()
	{
	// TODO Auto-generated method stub
		Session session = null;
		List<State> stateList=null;
		try {
		    session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(State.class);
			stateList = criteria.list();
			if(stateList.size()==0)
			{
			return null;
			}
			} 
		catch (Exception e) 
			{
			return null;
			}

		finally 
		{
			session.close();
		}
		return stateList;
	   }

	@Override
	public List<District> getDistrictName()
	{
		// TODO Auto-generated method stub
		
		Session session = null;
		List<District> districtList=null;
		try {
		    session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(District.class);
			districtList = criteria.list();
			if(districtList.size()==0)
			{
			return null;
			}
			} 
		catch (Exception e) 
			{
			return null;
			}

		finally 
		{
			session.close();
		}
		return districtList;
	  }

	//get district name by state
	@Override
	public List<District> getDistrictNameBysate(State state) {
		// TODO Auto-generated method stub
		Session session=null;
		List<District> districtList=null;
		try
		{
		session=sessionFactory.openSession();
		//Criteria criteria=session.createCriteria(District.class);
		//criteria.equals(state.getState_id());
		//districtList=criteria.list();
		String hql = "select dist_id, dist_name from District where state_id="+state.getState_id();
		System.out.println("query>>>>>>>>>>>>>>"+hql);
		Query query = session.createQuery(hql);
		districtList = query.list();
		System.out.println("what is District Name list"+districtList.size());
		
		if(districtList.size()>0)
		{
		return districtList;
		}
		else
		{
		return null;	
		}
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		finally
		{
		session.close();
		}
		return districtList;
	    }

	// Get Manager Details
	@Override
	public List<Manager> getManagerDetails()
	{
	// TODO Auto-generated method stub
		Session session=null;
		List<Manager> managerList=null;
		try
		{
		session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Manager.class);
		managerList=criteria.list();
		if(managerList.size()==0)
		{
		return null;
		}
		}
	
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		finally
		{
		session.close();
		}
	   return managerList;
	   }
    }
