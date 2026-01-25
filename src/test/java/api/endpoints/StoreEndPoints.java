package api.endpoints;

import api.payload.Store;
import api.utilities.RequestSpecUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

public class StoreEndPoints {
	
	public static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("urls"); //load the property file
		return routes;
	}

	//Create order
	public static Response createOrder(Store payload) {
		
		Response response = 
				given(RequestSpecUtil.getRequestSpec())
					.body(payload)
				.when()
					.post(getURL().getString("store_post_url"));
		
		return response;
	}
	
	//Get order
	public static Response getOrder(int orderId) {
			
		Response response = 
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("orderId", orderId)
				.when()
					.get(getURL().getString("store_get_url"));
			
		return response;
		}
	
	
	//Delete order
	public static Response deleteOrder(int orderId) {
				
		Response response = 
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("orderId", orderId)
				.when()
					.delete(getURL().getString("store_get_url"));
				
		return response;
		}
	
}
