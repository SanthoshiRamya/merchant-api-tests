package com.merchant.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.merchant.api.data.Post;
import com.merchant.api.data.RandomDataGenerator;
import com.merchant.api.data.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest extends TestBase {
	
	private User user = null;
	private Post post = null;

	@BeforeClass
	public void setUp() {
		
	   RestAssured.basePath = "/posts";
		
	   user = RandomDataGenerator.getUser();
	   ObjectCreatorService.createUser(user);
	}

	@Test
	public void createPost() {

		post = RandomDataGenerator.getPost(user);
		ObjectCreatorService.createPost(user, post);
	}

	@Test(dependsOnMethods = "createPost")
	public void getPost() {
		given().when().get("/" + post.getId()).then().statusCode(200).spec(post.getPostSpec());
	}

	@Test(dependsOnMethods = "createPost")
	public void updatePost() {
		given().accept(ContentType.JSON).contentType(ContentType.JSON).body(post).when().put("/" + post.getId()).then()
				.statusCode(200).spec(post.getPostSpec()).extract().path("id").toString();
	}
	

}
