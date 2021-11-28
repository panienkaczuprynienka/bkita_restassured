package pl.akademiaqa.request.booking;

import io.restassured.RestAssured;
import pl.akademiaqa.url.BookingUrl;

public class GetHealthCheckRequest {

  public static void getHealthCheck(){
     RestAssured
            .given()
            .when()
            .get(BookingUrl.BASE_URL + BookingUrl.PING)
            .then()
            .statusCode(201)
            .extract()
            .response();

  }}
