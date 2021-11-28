package pl.akademiaqa.request.booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pl.akademiaqa.url.BookingUrl;

public class DeleteBookingRequest {


  public static void deleteBookingRequest(int id, String token) {
    Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .header("Cookie", "token=" + token)
            .when()
            .delete(BookingUrl.BASE_URL + BookingUrl.BOOKING + id)
            .then()
            .statusCode(201)
            .extract()
            .response();

    response.prettyPrint();
  }
}
