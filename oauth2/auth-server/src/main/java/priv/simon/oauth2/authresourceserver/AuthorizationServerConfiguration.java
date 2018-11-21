package priv.simon.oauth2.authresourceserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 授权服务器配置
 *
 * @author simon
 * @create 2018-10-29 11:51
 **/
@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
  
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  UserDetailsService userDetailsService;
  
  // 使用最基本的InMemoryTokenStore生成token
  @Bean
  public TokenStore memoryTokenStore() {
    return new InMemoryTokenStore();
  }
  
  /**
   * 配置客户端详情服务
   * 客户端详细信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
   * @param clients
   * @throws Exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
            .withClient("client1")//用于标识用户ID
            .authorizedGrantTypes("client_credentials","refresh_token")//授权方式
            .scopes("test")//授权范围
            .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"));//客户端安全码,secret密码配置从 Spring Security 5.0开始必须以 {bcrypt}+加密后的密码 这种格式填写;
  }
  
  /**
   * 用来配置令牌端点(Token Endpoint)的安全约束.
   * @param security
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    /* 配置token获取合验证时的策略 */
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
  }
  
  /**
   * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
   * @param endpoints
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    // 配置tokenStore
    endpoints.authenticationManager(authenticationManager).tokenStore(memoryTokenStore()).userDetailsService(userDetailsService);
  }
}
