 	package com.lti.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TBL_ADMIN")
public class Admin {
	
	@Id
	@GeneratedValue
	@Column(name="admin_id")
	private int adminId;
	
	private String name;
	@Column(name="email")
	private String emailId;
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy="admin")
    private Set<Retailer> retailers;
    
	public Set<Retailer> getRetailers() {
		return retailers;
	}
	public void setRetailers(Set<Retailer> retailers) {
		this.retailers = retailers;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
