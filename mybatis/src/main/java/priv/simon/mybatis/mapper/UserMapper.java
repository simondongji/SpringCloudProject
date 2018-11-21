package priv.simon.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import priv.simon.mybatis.model.User;

import java.util.List;

public interface UserMapper {
  /**
   * 插入数据
   * @param record  数据记录
   * @return  成功操作的记录数
   */
  @Insert("INSERT INTO user(userId,username,password,phone}) VALUES(#{userId}, #{username}, #{password},#{phone})")
  int insert(User record);
  
  /**
   * 查询所有用户
   *
   * @return 所有用户数据
   */
  @Select("SELECT * FROM user")
  @Results({
          @Result(property = "userId",column = "userId"),
          @Result(property = "username",column = "username"),
          @Result(property = "password",column = "password"),
          @Result(property = "phone",column = "phone")
  })
  List <User> selectUsers();
}