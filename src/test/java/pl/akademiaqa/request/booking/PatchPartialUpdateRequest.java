package pl.akademiaqa.request.booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.models.Booking;
import pl.akademiaqa.url.BookingUrl;

public class PatchPartialUpdateRequest {

  public static Response patchPartialUpdateBooking(int bookingId, JSONObject bookingBody, String token) {

    Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            //.accept(ContentType.JSON)
            .header("Cookie", "token=" + token)
            .when()
            .body(bookingBody.toString())
            .patch(BookingUrl.BASE_URL + BookingUrl.BOOKING + bookingId)
            .then()
            .statusCode(200)
            .extract()
            .response();
    return response;
  }
}
