package com.merchant.api.data;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Post {
	
	private String id;
	
	private String userId;

	private String title;
	
	private String body;
	

	public Post(String userId, String title, String body) {
		super();
		this.userId = userId;
		this.title = title;
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	@JsonIgnore
    public ResponseSpecification getPostSpec(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder ();
        builder.expectContentType(ContentType.JSON);
        builder.expectBody("userId", equalTo(this.getUserId()));
        builder.expectBody("title", equalTo(this.getTitle()));
        builder.expectBody("body", equalTo(this.getBody()));
        builder.expectBody("id", not(anyOf(nullValue(),empty())));
        return builder.build ();
    }


}
