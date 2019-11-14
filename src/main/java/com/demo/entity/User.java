package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class User {
	@Id
	@GeneratedValue	
	private Long id;
	private String lastName;
	private String firstName;
	
	public User() {		
	}
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
    }
	public User(Long id, String firstName, String lastName) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
      this.firstName = firstName;
	}
	public String getFirstName() {
      return firstName;
	}
	public String getLastName() {
      return lastName;
	}
	public void setLastName(String lastName) {
      this.lastName = lastName;
	}
   @Override
   public String toString() {
      return String.format("User [id=%s, firstName=%s, lastName=%s]", id, firstName, lastName);
   }   
}