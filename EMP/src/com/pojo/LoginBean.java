package com.pojo;

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
@Table(name="users", schema ="emp")
public class LoginBean implements Serializable
{
private static final long serialVersionUID = 1L;
@GenericGenerator
(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="emp.username")})
@Id
@GeneratedValue(generator = "sequence")

@Column(name="user_id")
private long id;
@Basic(optional = false)

@Column(name="username")
private String username;

@Column(name="password")
private String password;


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

	
}
