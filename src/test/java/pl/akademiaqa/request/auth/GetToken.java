package pl.akademiaqa.request.auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pl.akademiaqa.models.Login;
import pl.akademiaqa.models.LoginModel;
import pl.akademiaqa.url.BookingUrl;

public class GetToken {

  public static String getToken(Login loginData) {
    Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .when()
            .body(loginData)
            .post(BookingUrl.BASE_URL + BookingUrl.AUTH)
            .then()
            .statusCode(200)
            .extract().response();

    response.prettyPrint();
    JsonPath json = response.jsonPath();
    System.out.println("token to " + json.getString("token"));
    return json.getString("token");


  }
}
