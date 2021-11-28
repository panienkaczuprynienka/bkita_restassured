package pl.akademiaqa.models;

import org.json.JSONObject;

public class BookingModel {

  public static JSONObject getDefaultBooking(){
    JSONObject bookingdates = new JSONObject();
    bookingdates.put("checkin", "2018-01-01");
    bookingdates.put("checkout", "2018-01-02");

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("firstname", "Janina");
    jsonObject.put("lastname", "Żak");
    jsonObject.put("totalprice", 210);
    jsonObject.put("depositpaid", false);
    jsonObject.put("additionalneeds", "sauna");
    jsonObject.put("bookingdates", bookingdates);

    return jsonObject;
  }

}
