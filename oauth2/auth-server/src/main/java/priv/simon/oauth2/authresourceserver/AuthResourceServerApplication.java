package priv.simon.oauth2.authresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableAuthorizationServer
@SpringBootApplication
public class AuthResourceServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthResourceServerApplication.class, args);
  }
}
