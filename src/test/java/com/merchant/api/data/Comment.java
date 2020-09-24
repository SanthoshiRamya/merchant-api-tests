package com.merchant.api.data;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Comment {
	
	private String id;
	private String postId;
	private String userId;
	private String body;
	
	
	public Comment(String postId, String userId, String body) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.body = body;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@JsonIgnore
    public ResponseSpecification getCommentSpec(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder ();
        builder.expectContentType(ContentType.JSON);
        builder.expectBody("userId", equalTo(this.getUserId()));
        builder.expectBody("postId", equalTo(this.getPostId()));
        builder.expectBody("body", equalTo(this.getBody()));
        builder.expectBody("id", not(anyOf(nullValue(),empty())));
        return builder.build ();
    }
	
	
	
	
	

}
