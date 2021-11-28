package pl.akademiaqa.test.booking;

import org.junit.jupiter.api.BeforeAll;
import pl.akademiaqa.models.Login;
import pl.akademiaqa.request.auth.GetToken;

public class TestBase {

  public static String token;
  @BeforeAll
  public static void setUp() {
    token = GetToken.getToken(Login.builder().username("admin").password("password123").build());
  }
}
