package pl.akademiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.models.Booking;
import pl.akademiaqa.models.BookingDates;
import pl.akademiaqa.request.booking.PostBookingRequest;

public class CreateBookingTest {

  @Test
  public void createBooking() {
    Booking bookingBody = Booking.builder().firstname("Patka").lastname("Patkowska").totalprice(1200).depositpaid(true)
            .bookingdates(BookingDates.builder().checkin("2018-01-01").checkout("2019-01-01").build()).additionalneeds("sauna").build();

    Response response = PostBookingRequest.createBooking(bookingBody);

    JsonPath json = response.jsonPath();
    json.prettyPrint();
    //assertThat(json.getString("booking.firstname")).isEqualTo(body.get("firstname"));
    //assertThat(json.getString("booking.lastname")).isEqualTo(body.get("lastname"));
  }
}
