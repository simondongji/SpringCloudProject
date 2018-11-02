package priv.simon.apollo.apolloclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Java Config方式
 *
 * @author simon
 * @create 2018-11-02 15:00
 **/
@Configuration
public class JavaConfigBean {
  @Value("${timeout:20}")
  private int timeout;
  
  public int getTimeout() {
    return timeout;
  }
}
