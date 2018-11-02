package priv.simon.apollo.apolloclient;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.spi.SyncResolver;
import java.util.List;
import java.util.Set;

@EnableApolloConfig
@SpringBootApplication
@RestController
public class ApolloClientApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(ApolloClientApplication.class, args);
  }
  
  //1.Java Config方式
  @Autowired
  JavaConfigBean javaConfigBean;
  
  @RequestMapping("/index1")
  public String hello1(){
    return javaConfigBean.getTimeout()+"";
  }
  
  //2. ConfigurationProperties使用方式
  @Autowired
  SampleRedisConfig sampleRedisConfig;
  
  @RequestMapping("/index2")
  public String hello2(){
    return sampleRedisConfig.getCommandTimeout()+"--"+sampleRedisConfig.getExpireSeconds();
  }
  // 3. @ApolloConfig使用
  @ApolloConfig
  private Config config;
  
  @RequestMapping("/index3")
  public String hello3(){
    Set <String> propertyNames = config.getPropertyNames();
    propertyNames.forEach(key -> {
      System.err.println(key+"="+config.getIntProperty(key,0));
    });
    return propertyNames.toString();
  }
  
  @ApolloConfigChangeListener
  private void someOnChange(ConfigChangeEvent changeEvent) {
    //update injected value of batch if it is changed in Apollo
    if (changeEvent.isChanged("timeout")) {
      System.out.println(config.getIntProperty("timeout", 0));
    }
  }
  //4. @ApolloJsonValue使用
  @ApolloJsonValue("${jsonBeanProperty:[]}")
  private List<User> anotherJsonBeans;
  
  @RequestMapping("/index4")
  public void hello4(){
    anotherJsonBeans.forEach(item -> {
      System.err.println(item.getUsername()+"--"+item.getPassword());
    });
  }
}
