package api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class APITest {

    @Test
    public void getUser() {

        Response response =

                given()

                .when()
                .get("https://reqres.in/api/users/2");

        System.out.println(response.getStatusCode());

        String firstName =
                response.jsonPath()
                        .getString("data.first_name");

        System.out.println(firstName);
    }
}