package com.merchant.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.merchant.api.data.RandomDataGenerator;
import com.merchant.api.data.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserTest extends TestBase {
	
	private User user;
	
	@BeforeClass
	public void beforeClass() {
        RestAssured.basePath = "/users";

        user = RandomDataGenerator.getUser();
        
	}

	@Test
	public void createUser() {

		ObjectCreatorService.createUser(user);
		Reporter.log("Created a new user = " + user.getId());
	}
	
	@Test(dependsOnMethods = "createUser")
	public void getUser() {
		
		given().
				when().get("/"+user.getId()).then().
				statusCode(200).
				spec(user.getUserSpec());

		Reporter.log("User = " + user.toString());
	}
	
	
	@Test(dependsOnMethods = "createUser")
	public void updateUser() {
		
		user.setFirstName("NewFirstName");
		given().accept(ContentType.JSON).contentType(ContentType.JSON).body(user).
				when().put("/"+user.getId()).then().
				statusCode(200).
				spec(user.getUserSpec()).extract().
                path("id").toString();

		Reporter.log("Updated user name = " + user.getFirstName());
	}
	
	

}
