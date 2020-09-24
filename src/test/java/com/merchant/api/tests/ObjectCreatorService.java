package com.merchant.api.tests;

import static io.restassured.RestAssured.given;

import com.merchant.api.data.Comment;
import com.merchant.api.data.Post;
import com.merchant.api.data.User;

import io.restassured.http.ContentType;

public class ObjectCreatorService {

	
	public static void createUser(User user) {
		String id = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(user).when().post().then().statusCode(201)
		.spec(user.getUserSpec()).extract().path("id").toString();
		user.setId(id);
	}
	
	
	
	public static void createPost(User user, Post post) {
		String id =  given().accept(ContentType.JSON).contentType(ContentType.JSON).body(post).when().post().then().statusCode(201)
		.spec(post.getPostSpec()).extract().path("id").toString();
		post.setId(id);
		
	}
	
	
	
	
	public static void createComment(User user, Post post, Comment comment) {
		String id = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(comment).when().post().then()
		.statusCode(201).spec(comment.getCommentSpec()).extract().path("id").toString();
		comment.setId(id);
	}
	
	
}
