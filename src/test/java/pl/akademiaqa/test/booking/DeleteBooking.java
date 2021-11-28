package pl.akademiaqa.test.booking;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.models.Booking;
import pl.akademiaqa.models.BookingDates;
import pl.akademiaqa.models.Login;
import pl.akademiaqa.request.auth.GetToken;
import pl.akademiaqa.request.booking.DeleteBookingRequest;
import pl.akademiaqa.request.booking.GetBookingIdsRequest;
import pl.akademiaqa.request.booking.PostBookingRequest;

public class DeleteBooking extends TestBase {

  @Test
  public void deleteBooking() {
    // 1. Create booking to delete
    Booking bookingBody = Booking.builder().firstname("Eleonora").lastname("Sliwinska").totalprice(1450).depositpaid(false)
            .bookingdates(BookingDates.builder().checkin("2021-01-01").checkout("2021-01-01").build()).additionalneeds("sauna").build();

    Response response = PostBookingRequest.createBooking(bookingBody);
    JsonPath json = response.jsonPath();
    int bookingid = json.getInt("bookingid");
    System.out.println("Wybrane booking id to " + bookingid);

    DeleteBookingRequest.deleteBookingRequest(bookingid, token);

    Response deletedBooking = GetBookingIdsRequest.getBookingById(bookingid);
    Assertions.assertThat(deletedBooking.statusCode()).isEqualTo(404);


  }
}
