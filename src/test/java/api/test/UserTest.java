package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserTest {
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		System.out.println("********** User Test **********");
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	
	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("******* Creating user *******");
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().body();
		
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), String.valueOf(userPayload.getId()));
		logger.info("******* User is created *******");
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("******* Reading user *******");
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		response.then().log().body();
		
		//Schema Validation
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/user_schema.json"));
				
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getInt("id"), this.userPayload.getId());
		Assert.assertEquals(response.jsonPath().getString("username"), this.userPayload.getUsername());
		Assert.assertEquals(response.jsonPath().getString("firstName"), this.userPayload.getFirstName());
		Assert.assertEquals(response.jsonPath().getString("lastName"), this.userPayload.getLastName());
		Assert.assertEquals(response.jsonPath().getString("email"), this.userPayload.getEmail());
		Assert.assertEquals(response.jsonPath().getString("password"), this.userPayload.getPassword());
		Assert.assertEquals(response.jsonPath().getString("phone"), this.userPayload.getPhone());
		Assert.assertEquals(response.jsonPath().getInt("userStatus"), this.userPayload.getUserStatus());
		logger.info("******* User data is read *******");
	}
	@Test(priority = 3)
	public void testUpdateUserByName() {
		logger.info("******* Updating user *******");
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Checking user updating
		Response responseAfterUpdate = UserEndPoints.getUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().body();
		logger.info("******* User is updated *******");
	}
	
	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("******* Deleting user *******");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().body();
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), this.userPayload.getUsername());
		logger.info("******* User is deleted *******");
	}
	
}
