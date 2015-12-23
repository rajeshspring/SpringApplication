package com.dao;

import java.util.List;

import com.formbean.EmployeeForm;
import com.master.pojo.District;
import com.master.pojo.State;
import com.pojo.Employee;;

public interface EmployeeDao
{
public boolean addEmpDetails(EmployeeForm userForm);
public List<Employee> getAllRecords(String page);
public List<Employee> employeeView(Employee employee);
public Employee employeeViewDetails(Employee employee);
public boolean employeeDelete(Employee employee);
public EmployeeForm updateEmployee(Employee employee);

public State getParentSateName(State state);
public State getOfficeSateName(State state);

public List<Employee> employeeDetailsWithJasper(Employee employee);

}
