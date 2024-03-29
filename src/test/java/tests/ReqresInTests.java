package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ReqresInTests {

    @Test
    void successfulLogin() {
        /*
         request: https://reqres.in/api/login
         data: {
            "email": "eve.holt@reqres.in",
            "password": "cityslicka"
}       }
         responce:
         {
                "token": "QpwL5tke4Pnpja7X4"
         }
         */

        String authorizedData = "{ \"email\": \"eve.holt@reqres.in\"," +
                " \"password\": \"cityslicka\" }";

        given()
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void missingPasswordLogin() {
        /*
         request: https://reqres.in/api/login
         data: {
            "email": "eve.holt@reqres.in",
}       }
         responce:
         {
                "error": "missing password"
         }
         */

        String authorizedData = "{ \"email\": \"eve.holt@reqres.in\"}";

        Response response = given()
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"))
                .extract().response();
        System.out.println(response.asString());
    }

}
