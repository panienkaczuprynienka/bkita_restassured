package pl.akademiaqa.request.booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.models.Booking;
import pl.akademiaqa.url.BookingUrl;

import java.awt.print.Book;
import java.sql.ResultSet;

public class PutUpdateBookingRequest {

  public static Response putUpdateBooking(int bookingId, Booking bookingBody, String token) {
    Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .header("Cookie", "token=" + token)
            .when()
            .body(bookingBody)
            .put(BookingUrl.BASE_URL + BookingUrl.BOOKING + bookingId)
            .then()
            .statusCode(200)
            .extract()
            .response();

    return response;
  }
}
