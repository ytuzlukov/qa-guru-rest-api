package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ReqresInHomeworkTests {

    @Test
    void successfulCreateUser() {
        /*
         request: https://reqres.in/api/users
         data: {
                "name": "morpheus",
                "job": "leader"
                }
         responce:
                {
                    "name": "morpheus",
                    "job": "leader",
                    "id": "805",
                    "createdAt": "2022-05-08T17:13:44.666Z"
                }
         */

        String authorizedData = "{ \"name\": \"yan\", \"job\": \"student\" }";

        Response response = given()
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", is("yan"))
                .body("job", is("student"))
                .extract().response();
        System.out.println("response.asString() = " + response.asString());
    }

    @Test
    void successfulCreateUserWithoutName() {
        /*
         request: https://reqres.in/api/users
         data: {
                "job": "leader"
                }
         responce:
         {
                "name": "",
                "job": "leader",
                "id": "42",
                "createdAt": "2022-05-08T16:51:21.636Z"
         }
         */

        String authorizedData = "{ \"job\": \"student\" }";

        given()
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("job", is("student"));
    }

    @Test
    void successfulCreateUserWithoutJob() {
        /*
         request: https://reqres.in/api/users
         data: {
                "name": "yan",
                "job": ""
                }
         responce:
         {
                "name": "yan",
                "job": "",
                "id": "42",
                "createdAt": "2022-05-08T16:51:21.636Z"
         }
         */

        String authorizedData = "{ \"name\": \"yan\"}";

        given()
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", is("yan"));
    }

    @Test
    void successfulRegister() {
        /*
         request:     https://reqres.in/api/register

         data: {
            "email": "eve.holt@reqres.in",
            "password": "pistol"
}       }
         responce:
         {
                "token": "QpwL5tke4Pnpja7X4"
         }
         */

        String authorizedData = "{ \"email\": \"eve.holt@reqres.in\"," +
                " \"password\": \"pistol\" }";

        Response response = given()
                .body(authorizedData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"))
                .extract().response();

        System.out.println("response.asString() = " + response.asString());
    }

    @Test
    void successfulGetUserFirstname() {
        /*
         request:     https://reqres.in/api/users/2

         responce:
         {
                {
            "data": {
                "id": 2,
                "email": "janet.weaver@reqres.in",
                "first_name": "Janet",
                "last_name": "Weaver",
                "avatar": "https://reqres.in/img/faces/2-image.jpg"
            },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
         */

        given()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", is("Janet"));
    }

    @Test
    void successfulGetUserLastname() {
        /*
         request:     https://reqres.in/api/users/2

         responce:
         {
                {
            "data": {
                "id": 2,
                "email": "janet.weaver@reqres.in",
                "first_name": "Janet",
                "last_name": "Weaver",
                "avatar": "https://reqres.in/img/faces/2-image.jpg"
            },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
         */

        given()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.last_name", is("Weaver"));
    }

    @Test
    void successfulDeleteUser() {
        /*
         request:     https://reqres.in/api/users/2

         responce:
         {
                {
            "data": {
                "id": 2,
                "email": "janet.weaver@reqres.in",
                "first_name": "Janet",
                "last_name": "Weaver",
                "avatar": "https://reqres.in/img/faces/2-image.jpg"
            },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
         */

        given()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }

}
