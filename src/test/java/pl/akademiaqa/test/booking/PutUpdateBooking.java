package pl.akademiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.models.Booking;
import pl.akademiaqa.models.BookingDates;
import pl.akademiaqa.request.booking.PostBookingRequest;
import pl.akademiaqa.request.booking.PutUpdateBookingRequest;

public class PutUpdateBooking extends TestBase {

  @Test
  public void putUpdateBooking() {
    // 1. Create booking
    Booking bookingbody = Booking.builder().firstname("Patka").lastname("Patkowska").totalprice(1200).depositpaid(true)
            .bookingdates(BookingDates.builder().checkin("2018-01-01").checkout("2019-01-01").build()).additionalneeds("sauna").build();
    Response response = PostBookingRequest.createBooking(bookingbody);

    JsonPath json = response.jsonPath();
    int bookingid = json.getInt("bookingid");
    System.out.println("Wybrane booking id to " + bookingid);

    //body changed
    bookingbody.setDepositpaid(false);
    bookingbody.setAdditionalneeds("terrarium");

    Response responseAfterChange = PutUpdateBookingRequest.putUpdateBooking(bookingid, bookingbody, token);
    JsonPath jsonAfterChange = responseAfterChange.jsonPath();
    Assertions.assertThat(jsonAfterChange.getBoolean("depositpaid")).isFalse();
    Assertions.assertThat(jsonAfterChange.getString("additionalneeds")).isEqualTo("terrarium");


  }
}
