package com.merchant.api.data;

import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class User {
	private String id;
	
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	
	

	public User(String username, String firstName, String lastName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	@JsonIgnore
    public ResponseSpecification getUserSpec(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder ();
        builder.expectContentType(ContentType.JSON);
        builder.expectBody("firstName", equalTo(this.getFirstName()));
        builder.expectBody("lastName", equalTo(this.getLastName()));
        builder.expectBody("id", not(anyOf(nullValue(),empty())));
        builder.expectBody("username", equalTo(this.getUsername()));
        return builder.build ();
    }


}
