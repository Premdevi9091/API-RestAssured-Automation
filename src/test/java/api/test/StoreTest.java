package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class StoreTest {

	Faker faker;
	Store storePayload;
	
	@BeforeClass
	public void setupData() {
		System.out.println("********** Store Test **********");
		faker = new Faker();
		storePayload = new Store();
		
		storePayload.setId(faker.number().numberBetween(1, 1000));
		storePayload.setPetId(faker.number().numberBetween(500, 5000));
		storePayload.setQuantity(faker.number().numberBetween(1, 10));
		storePayload.setShipDate(java.time.OffsetDateTime.now().toString());
		storePayload.setStatus("placed");
		storePayload.setComplete(true);
	}
	
	@Test(priority = 1)
	public void testCreateOrder() {
		Response response = StoreEndPoints.createOrder(storePayload);
		response.then().log().body();
		
		//schema validation
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/store_schema.json"));
		
		//Assertion
		Assert.assertEquals(response.jsonPath().getInt("id"), this.storePayload.getId());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void testGetOrderByID() {
		Response response = StoreEndPoints.getOrder(this.storePayload.getId());
		response.then().log().body();
		
		//schema validation
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/store_schema.json"));
				
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	//Delete order
	@Test(priority = 3)
	public void testDeleteOrderByID() {
		Response response = StoreEndPoints.deleteOrder(this.storePayload.getId());
		response.then().log().body();
		
		//Assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), String.valueOf(this.storePayload.getId()));
	}
}
	
