package com.dao;

import java.util.List;

import com.master.pojo.District;
import com.master.pojo.State;
import com.pojo.Manager;

public interface MasterServiceDao
{
public List<State> getStateName();
public List<District> getDistrictName();
public List<District> getDistrictNameBysate(State state);

//Get Manager Details
public List<Manager> getManagerDetails();

}
