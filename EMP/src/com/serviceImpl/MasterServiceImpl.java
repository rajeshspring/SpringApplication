package com.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.EmployeeDao;
import com.dao.MasterServiceDao;
import com.master.pojo.District;
import com.master.pojo.State;
import com.pojo.Manager;
import com.service.MasterService;


@Repository
public class MasterServiceImpl implements MasterService
{

@Autowired(required=true)
MasterServiceDao masterServiceDao;
	
public List<State> getStateName()
{
	return masterServiceDao.getStateName();
}

@Override
public List<District> getDistrictName() {
	// TODO Auto-generated method stub
	return masterServiceDao.getDistrictName();
}

@Override
public List<District> getDistrictNameBysate(State state) {
	// TODO Auto-generated method stub
	return masterServiceDao.getDistrictNameBysate(state);
}


// Get Manager Details
@Override
public List<Manager> getManagerDetails() {
	// TODO Auto-generated method stub
	return masterServiceDao.getManagerDetails();
}

}
