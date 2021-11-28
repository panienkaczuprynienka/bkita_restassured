package pl.akademiaqa.request.booking;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.akademiaqa.url.BookingUrl;

public class GetBookingIdsRequest {

  public static Response getAllBookingIds() {
    return RestAssured
            .given()
            .when()
            .get(BookingUrl.BASE_URL + BookingUrl.BOOKING)
            .then()
            .statusCode(200)
            .extract()
            .response();
  }

  public static Response getBookingById(int bookingId) {
    return RestAssured
            .given()
            .when()
            .get(BookingUrl.BASE_URL + BookingUrl.BOOKING + bookingId)
            .then()
            .extract()
            .response();
  }
}
