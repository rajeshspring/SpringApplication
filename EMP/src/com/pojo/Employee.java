package com.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee1", schema ="emp")
public class Employee implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@GenericGenerator
	(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="emp.employeesequence")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name="emp_id")
	private Long empId;
	@Basic(optional = false)
	
	
	@Column(name="empname")
	private String name;
	
	@Column(name ="date_of_birth")
	private Date date_of_birth;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	

	@Column(name="lastname")
	private String lastname;
	
	@Column(name="education")
	private String education;
	
	@Column(name="profile")
	private String profile;
	
	@Column(name="email")
	private String email;
	
	@Column(name="employeetype")
	private String employeeType;
	
	@Column(name="parentstate")
	private String parentstate;
	
	@Column(name="parentdistrict")
	private String parentdistrict;
	
	@Column(name="parnetpincode")
	private String parnetPinCode;
	
	@Column(name="officeaddress")
	private String officeaddress;
	
	@Column(name="officestate")
	private String officestate;
	
	@Column(name="officedistrict")
	private String officedistrict;
	
	@Column(name="officepincode")
	private String officePinCode;
	
	@Column(name="dateofjoin")
	private Date dateofjoin;
	
	@Column(name="dateofleave")
	private Date dateofleave;
	
	
	
	public Date getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public Date getDateofleave() {
		return dateofleave;
	}
	public void setDateofleave(Date dateofleave) {
		this.dateofleave = dateofleave;
	}
	
	
	
	
	
	
	
	
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getParentstate() {
		return parentstate;
	}
	public void setParentstate(String parentstate) {
		this.parentstate = parentstate;
	}
	public String getParentdistrict() {
		return parentdistrict;
	}
	public void setParentdistrict(String parentdistrict) {
		this.parentdistrict = parentdistrict;
	}
	public String getParnetPinCode() {
		return parnetPinCode;
	}
	public void setParnetPinCode(String parnetPinCode) {
		this.parnetPinCode = parnetPinCode;
	}
	public String getOfficeaddress() {
		return officeaddress;
	}
	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}
	public String getOfficestate() {
		return officestate;
	}
	public void setOfficestate(String officestate) {
		this.officestate = officestate;
	}
	public String getOfficedistrict() {
		return officedistrict;
	}
	public void setOfficedistrict(String officedistrict) {
		this.officedistrict = officedistrict;
	}
	public String getOfficePinCode() {
		return officePinCode;
	}
	public void setOfficePinCode(String officePinCode) {
		this.officePinCode = officePinCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
