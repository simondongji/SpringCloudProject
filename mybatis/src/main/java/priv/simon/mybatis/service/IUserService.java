package priv.simon.mybatis.service;

import com.github.pagehelper.PageInfo;
import priv.simon.mybatis.model.User;

/**
 * @author simon
 * @create 2018-11-19 12:26
 **/
public interface IUserService {
  int addUser(User user);
  PageInfo<User> findAllUser(int pageNum, int pageSize);
}
