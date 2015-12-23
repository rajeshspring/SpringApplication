package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.EmployeeDao;
import com.formbean.EmployeeForm;
import com.master.pojo.State;
import com.pojo.Employee;
import com.service.EmployeeSevice;

@Repository
public class EmployeeServiceImpl implements EmployeeSevice
{
    @Autowired(required=true)
	EmployeeDao employeeDao;	
@Override
public boolean addEmpDetails(EmployeeForm userForm)
{
	// TODO Auto-generated method stub
	return employeeDao.addEmpDetails(userForm);
}
@Override
public List<Employee> getAllRecords(String page) {
	// TODO Auto-generated method stub
	return employeeDao.getAllRecords(page);
}

@Override
public List<Employee> employeeView(Employee employee) {
	// TODO Auto-generated method stub
	return employeeDao.employeeView(employee);
}
@Override
public Employee employeeViewDetails(Employee employee) {
	// TODO Auto-generated method stub
	return employeeDao.employeeViewDetails(employee);
}
@Override
public boolean employeeDelete(Employee employee) {
	// TODO Auto-generated method stub
	return employeeDao.employeeDelete(employee);
}
@Override
public EmployeeForm updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
	return employeeDao.updateEmployee(employee);
}
@Override
public State getParentSateName(State state) {
	// TODO Auto-generated method stub
	return employeeDao.getParentSateName(state);
}
@Override
public State getOfficeSateName(State state) {
	// TODO Auto-generated method stub
	return employeeDao.getOfficeSateName(state);
}

/* jasper report */
@Override
public List<Employee> employeeDetailsWithJasper(Employee employee) {
	// TODO Auto-generated method stub
	return employeeDao.employeeDetailsWithJasper(employee);
}

}
