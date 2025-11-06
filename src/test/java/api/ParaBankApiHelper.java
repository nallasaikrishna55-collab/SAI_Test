package api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@Component
public class ParaBankApiHelper {

    @Value("${api.Url}")
    private String BASE_URL;


    public String registerUser(String username, String password) {
        RestAssured.baseURI = BASE_URL;

        SessionFilter session = new SessionFilter();

        given()
                .filter(session)
                .get("/parabank/register.htm");


        Response response = given()
                .filter(session)
                .contentType("application/x-www-form-urlencoded")
                .formParam("customer.firstName", "test")
                .formParam("customer.lastName", "test")
                .formParam("customer.address.street", "test")
                .formParam("customer.address.city", "test")
                .formParam("customer.address.state", "TX")
                .formParam("customer.address.zipCode", "12345")
                .formParam("customer.phoneNumber", "1234567899")
                .formParam("customer.ssn", "0987658")
                .formParam("customer.username", username)
                .formParam("customer.password", password)
                .formParam("repeatedPassword", password)
                .when()
                .post("/parabank/register.htm")
                .then()
                .statusCode(200)
                .body(containsString("Your account was created successfully"))
                .extract().response();

        return response.asString();
    }
}
