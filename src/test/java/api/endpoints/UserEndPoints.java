package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import api.utilities.RequestSpecUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//CRUD methods
public class UserEndPoints {

	public static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("urls"); //load the property file
		return routes;
	}
	
	//Create user
	public static Response createUser(User payload) {
		
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.body(payload)
				.when()
					.post(getURL().getString("post_url"));
		
		return response;
	}
	
	//Read user
	public static Response getUser(String userName) {
			
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("username", userName)
				.when()
					.get(getURL().getString("get_url"));
			
		return response;
	}
	
	//Update user
	public static Response updateUser(String userName, User payload) {
		
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.body(payload)
					.pathParam("username", userName)
				.when()
					.put(getURL().getString("update_url"));
		
		return response;
	}
	
	//Delete
	public static Response deleteUser(String userName) {
		
		Response response =
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("username", userName)
				.when()
					.delete(getURL().getString("delete_url"));
			
		return response;
	}
}
