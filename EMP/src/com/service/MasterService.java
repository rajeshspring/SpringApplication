package com.service;

import java.util.List;

import com.master.pojo.District;
import com.master.pojo.State;
import com.pojo.Manager;

public interface MasterService
{
	public List<State> getStateName();
	public List<District> getDistrictName();
	public List<District> getDistrictNameBysate(State state);
	
	//Get Manager Details
	public List<Manager> getManagerDetails();
	
}
