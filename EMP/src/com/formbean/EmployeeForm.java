package com.formbean;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

public class EmployeeForm {
	
	private String name;
	private String date_of_birth;
	private String empId;
	private String address;
	private String phone;
	private String lastname;
	private String education;
	private String profile;
	private String email;
	private String employeeType;
	private String parentstate;
	private String parentdistrict;
	private String parnetPinCode;
	private String officeaddress;
	private String officestate;
	private String officedistrict;
	private String officePinCode;
    private String dateofjoin;
    private String dateofleave;
    private String date_of_birth_error;
    private String dateofjoin_error;
    private String dateofleave_error;
    
    
    public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
    
	public String getDateofjoin_error() {
		return dateofjoin_error;
	}
	public void setDateofjoin_error(String dateofjoin_error) {
		this.dateofjoin_error = dateofjoin_error;
	}
	public String getDateofleave_error() {
		return dateofleave_error;
	}
	public void setDateofleave_error(String dateofleave_error) {
		this.dateofleave_error = dateofleave_error;
	}
	
	
	
   
	public String getDate_of_birth_error() {
		return date_of_birth_error;
	}
	public void setDate_of_birth_error(String date_of_birth_error) {
		this.date_of_birth_error = date_of_birth_error;
	}
	
	
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public String getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public String getDateofleave() {
		return dateofleave;
	}
	public void setDateofleave(String dateofleave) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
