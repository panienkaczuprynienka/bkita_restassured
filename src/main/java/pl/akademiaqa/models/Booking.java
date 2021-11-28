package pl.akademiaqa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class Booking {
  private String firstname;
  private String lastname;
  private int totalprice;
  private boolean depositpaid;
  private BookingDates bookingdates;
  private String additionalneeds;
}
