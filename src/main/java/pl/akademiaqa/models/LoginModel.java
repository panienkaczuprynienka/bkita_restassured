package pl.akademiaqa.models;

import org.json.JSONObject;

public class LoginModel {


  public static JSONObject getDefaultLoginData(){
    JSONObject login = new JSONObject();
    login.put("username", "admin");
    login.put("password", "password123");

    return login;
  }
}
