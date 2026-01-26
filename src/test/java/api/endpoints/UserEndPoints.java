package api.endpoints;

import static io.restassured.RestAssured.given;


import api.payload.User;
import api.utilities.ConfigReader;
import api.utilities.RequestSpecUtil;
import io.restassured.response.Response;

//CRUD methods
public class UserEndPoints {
	
	//Create user
	public static Response createUser(User payload) {
		
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.body(payload)
				.when()
					.post(ConfigReader.get("post_url"));
		
		return response;
	}
	
	//Read user
	public static Response getUser(String userName) {
			
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("username", userName)
				.when()
					.get(ConfigReader.get("get_url"));
			
		return response;
	}
	
	//Update user
	public static Response updateUser(String userName, User payload) {
		
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.body(payload)
					.pathParam("username", userName)
				.when()
					.put(ConfigReader.get("update_url"));
		
		return response;
	}
	
	//Delete
	public static Response deleteUser(String userName) {
		
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("username", userName)
				.when()
					.delete(ConfigReader.get("delete_url"));
			
		return response;
	}
}
