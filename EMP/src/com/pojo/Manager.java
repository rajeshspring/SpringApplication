package com.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="managers_details", schema ="emp")
public class Manager implements Serializable
{
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
@GenericGenerator
(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="emp.employeesequence")})
@Id
@GeneratedValue(generator = "sequence")
@Column(name="manager_id")
private Integer manager_id;

@Column(name="manager_name")
private String manager_name;

@Column(name="phone")
private String phone;

@OneToMany(mappedBy="OnsideEmployees")
private Set<OnsideEmployees> OnsideEmployees;

public Integer getManager_id() {
	return manager_id;
}
public void setManager_id(Integer manager_id) {
	this.manager_id = manager_id;
}
public String getManager_name() {
	return manager_name;
}
public void setManager_name(String manager_name) {
	this.manager_name = manager_name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}



}
