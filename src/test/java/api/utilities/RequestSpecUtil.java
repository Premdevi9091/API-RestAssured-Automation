package api.utilities;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RequestSpecUtil {

	
	public static RequestSpecification getRequestSpec() {
		
		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.log().method()
				.log().uri();
	}
}
