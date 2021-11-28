package pl.akademiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.models.Booking;
import pl.akademiaqa.models.BookingDates;
import pl.akademiaqa.models.Login;
import pl.akademiaqa.request.auth.GetToken;
import pl.akademiaqa.request.booking.PostBookingRequest;
import pl.akademiaqa.request.booking.PatchPartialUpdateRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class PatchPartialUpdateBookingTest extends TestBase {


  @Test
  public void patchPartialUpdateBooking() {
    // 1. Create booking
    Booking bookingbody = Booking.builder().firstname("Patka").lastname("Patkowska").totalprice(1200).depositpaid(true)
            .bookingdates(BookingDates.builder().checkin("2018-01-01").checkout("2019-01-01").build()).additionalneeds("sauna").build();
    Response response = PostBookingRequest.createBooking(bookingbody);

    JsonPath json = response.jsonPath();
    int bookingid = json.getInt("bookingid");
    System.out.println("Wybrane booking id to " + bookingid);

// 3 Partialupdate
    Booking bookingPartialUptadeBody = Booking.builder()
            .firstname("Joannna").lastname("Niejoannowa").build();

    JSONObject patchBody = new JSONObject();
    patchBody.put("firstname", "Janek");
    patchBody.put("lastname", "Złotoposlki");

    Response patchResponse = PatchPartialUpdateRequest.patchPartialUpdateBooking(bookingid, patchBody, token);
    patchResponse.prettyPrint();
    assertThat(patchResponse.jsonPath().getString("firstname")).isEqualTo("Janek");
    assertThat(patchResponse.jsonPath().getString("lastname")).isEqualTo("Złotoposlki");


  }
}
