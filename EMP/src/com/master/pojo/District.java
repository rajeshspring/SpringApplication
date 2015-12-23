package com.master.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="district_details", schema ="emp")
public class District implements Serializable
{
	
	
private static final long serialVersionUID = 1L;
@GenericGenerator
(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="emp.districtsequence")})
@Id
@GeneratedValue(generator = "sequence")
@Column(name="id")	
private Long dist_id;

@Column(name="district_name")	
private String dist_name;

public Long getState_id() {
	return state_id;
}
public void setState_id(Long state_id) {
	this.state_id = state_id;
}
@Column(name="state_id")
private Long state_id;


public Long getDist_id() {
	return dist_id;
}
public void setDist_id(Long dist_id) {
	this.dist_id = dist_id;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getDist_name() {
	return dist_name;
}
public void setDist_name(String dist_name) {
	this.dist_name = dist_name;
}

}
