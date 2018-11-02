package priv.simon.apollo.apolloclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ConfigurationProperties使用方式
 *
 * @author simon
 * @create 2018-11-02 9:30
 **/
@Configuration
@ConfigurationProperties(prefix = "redis.cache")
public class SampleRedisConfig {
  private int expireSeconds;
  private int commandTimeout;
  
  public void setExpireSeconds(int expireSeconds) {
    this.expireSeconds = expireSeconds;
  }
  
  public void setCommandTimeout(int commandTimeout) {
    this.commandTimeout = commandTimeout;
  }
  
  public int getExpireSeconds() {
    return expireSeconds;
  }
  
  public int getCommandTimeout() {
    return commandTimeout;
  }
}
