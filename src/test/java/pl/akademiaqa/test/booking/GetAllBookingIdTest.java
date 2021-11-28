package pl.akademiaqa.test.booking;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Assertions;
import org.json.HTTP;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.request.booking.GetBookingIdsRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllBookingIdTest {

  @Test
  public void getBookingIdsTest(){
    Response response = GetBookingIdsRequest.getAllBookingIds();

    JsonPath json = response.jsonPath();
    assertThat(json.getList("bookingid")).hasSizeGreaterThan(0);
    System.out.println(json.getList("bookingid").size());

  }
}
