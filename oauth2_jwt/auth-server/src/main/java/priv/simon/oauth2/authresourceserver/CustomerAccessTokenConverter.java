package priv.simon.oauth2.authresourceserver;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义CustomerAccessTokenConverter 这个类的作用主要用于AccessToken的转换，
 * 默认使用DefaultAccessTokenConverter 这个装换器
 * DefaultAccessTokenConverter有个UserAuthenticationConverter，这个转换器作用是把用户的信息放入token中，
 * 默认只是放入username
 * <p>
 * 自定义了下这个方法，加入了额外的信息
 * <p>
 * @author simon
 * @create 2018-11-14 10:26
 **/
public class CustomerAccessTokenConverter extends DefaultAccessTokenConverter {
  
  public CustomerAccessTokenConverter() {
    super.setUserTokenConverter(new CustomerUserAuthenticationConverter());
  }
  
  private class CustomerUserAuthenticationConverter extends DefaultUserAuthenticationConverter{
    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
      LinkedHashMap <String, Object> response = new LinkedHashMap <>();
      response.put("user_name", authentication.getName());
      if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
        response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
      }
      return response;
    }
  }
}
