package pl.akademiaqa.request.booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.models.Booking;
import pl.akademiaqa.models.BookingDates;
import pl.akademiaqa.url.BookingUrl;

import static org.assertj.core.api.Assertions.assertThat;

public class PostBookingRequest {

  public static Response createBooking(Booking bookingBody) {
    Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .when()
            .body(bookingBody)
            .post(BookingUrl.BASE_URL + BookingUrl.BOOKING)
            .then()
            .statusCode(200)
            .extract()
            .response();

    return response;
  }
}
