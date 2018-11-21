package priv.simon.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.simon.mybatis.model.User;
import priv.simon.mybatis.service.impl.UserService;

/**
 * @author simon
 * @create 2018-11-19 12:29
 **/
@RestController
public class UserController {
  @Autowired
  private UserService userService;
  
  @ResponseBody
  @PostMapping("/add")
  public int addUser(User user) {
    return userService.addUser(user);
  }
  
  @ResponseBody
  @GetMapping("/all")
  public Object findAllUser(
          @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                  int pageNum,
          @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                  int pageSize) {
    return userService.findAllUser(pageNum, pageSize);
  }
  
}
