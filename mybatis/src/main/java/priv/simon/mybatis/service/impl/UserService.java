package priv.simon.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.simon.mybatis.mapper.UserMapper;
import priv.simon.mybatis.model.User;
import priv.simon.mybatis.service.IUserService;

import java.util.List;

/**
 * @author simon
 * @create 2018-11-19 12:27
 **/
@Service
public class UserService implements IUserService {
  
  private final UserMapper userDao;
  
  @Autowired
  public UserService(UserMapper userDao) {
    this.userDao = userDao;
  }
  
  @Override
  public int addUser(User user) {
    return userDao.insert(user);
  }
  
  /*
   * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
   * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
   * pageNum 开始页数
   * pageSize 每页显示的数据条数
   * */
  @Override
  public PageInfo <User> findAllUser(int pageNum, int pageSize) {
    //将参数传给这个方法就可以实现物理分页了，非常简单。
    PageHelper.startPage(pageNum, pageSize);
    List <User> userDomains = userDao.selectUsers();
    return new PageInfo(userDomains);
  }
}
