package priv.simon.oauth2.authresourceserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResourceServerApplicationTests {

  @Test
  public void contextLoads() {
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDIyMTEwNDcsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiVVNFUiJdLCJqdGkiOiIzMTU5YjE5Yi1hNzkxLTQ3MzktODQxMC0zMGE1OTUwZmNjMTQiLCJjbGllbnRfaWQiOiJjbGllbnQxIiwic2NvcGUiOlsidGVzdCJdfQ.tMK5MP78Gm2rqgaQHkl-Vp3A8k3ehWFL7sQ0Bg05M8E";
    Jwt jwt = JwtHelper.decode(token);
    System.out.println(jwt.toString());
  }

}
