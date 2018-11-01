package priv.simon.apollo.apolloclient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableApolloConfig
@SpringBootApplication
@RestController
public class ApolloClientApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(ApolloClientApplication.class, args);
  }
  
  @RequestMapping("/index")
  public String hello(){
    return "hello man";
  }
}
