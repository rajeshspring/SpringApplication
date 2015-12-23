package com.master.pojo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="state_details", schema ="emp")
public class State implements Serializable
{
	private static final long serialVersionUID = 1L;
	@GenericGenerator
	(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="emp.statesequence")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name="state_id")
    private Long state_id;
	@Basic(optional = false)
	
	@Column(name="state_name")
    private String statename;



public Long getState_id() {
		return state_id;
	}
	public void setState_id(Long state_id) {
		this.state_id = state_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
public String getStatename() {
	return statename;
}
public void setStatename(String statename) {
	this.statename = statename;
}


	
	
	
}
