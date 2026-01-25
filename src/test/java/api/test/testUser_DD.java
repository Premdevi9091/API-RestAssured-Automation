package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class testUser_DD {
	
	String sheetname = "UserData.xlsx";
	User userPayload;
	
	@BeforeClass
	public void setup() {
		System.out.println("********** User Test using Data Driven Test **********");
		
	}
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String email, String pwd, String phone) {
		
		userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().body();
		
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), String.valueOf(userPayload.getId()));
		
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testGetUserByName(String userName) {
		Response response = UserEndPoints.getUser(userName);
		response.then().log().body();
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("username"), userName);
		
	}
	
	
	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		Response response = UserEndPoints.deleteUser(userName);
		response.then().log().body();
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), userName);
		
	}
}
