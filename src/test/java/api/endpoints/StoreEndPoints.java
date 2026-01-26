package api.endpoints;

import api.payload.Store;
import api.utilities.ConfigReader;
import api.utilities.RequestSpecUtil;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class StoreEndPoints {

	//Create order
	public static Response createOrder(Store payload) {
		
		Response response = 
				given(RequestSpecUtil.getRequestSpec())
					.body(payload)
				.when()
					.post(ConfigReader.get("store_post_url"));
		
		return response;
	}
	
	//Get order
	public static Response getOrder(int orderId) {
			
		Response response = 
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("orderId", orderId)
				.when()
					.get(ConfigReader.get("store_get_url"));
			
		return response;
		}
	
	
	//Delete order
	public static Response deleteOrder(int orderId) {
				
		Response response = 
				given(RequestSpecUtil.getRequestSpec())
					.pathParam("orderId", orderId)
				.when()
					.delete(ConfigReader.get("store_delete_url"));
				
		return response;
		}
	
}
