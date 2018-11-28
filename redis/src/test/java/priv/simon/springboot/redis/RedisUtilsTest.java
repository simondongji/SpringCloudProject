package priv.simon.springboot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {

  @Autowired
  private RedisUtils redisUtils;

  @Test
  public void expire() {
    redisUtils.expire("name",230);
  }

  @Test
  public void getExpire() {
    redisUtils.getExpire("name");
  }

  @Test
  public void hasKey() {
    redisUtils.hasKey("name");
  }

  @Test
  public void del() {
    redisUtils.del("name");
  }

  @Test
  public void get() {
    System.out.println(redisUtils.get("name"));
  }

  @Test
  public void set() {
    redisUtils.set("nama","221");
  }

  @Test
  public void set1() {
  }

  @Test
  public void incr() {
  }

  @Test
  public void decr() {
  }

  @Test
  public void hget() {
  }

  @Test
  public void hmget() {
  }

  @Test
  public void hmset() {
  }

  @Test
  public void hmset1() {
  }

  @Test
  public void hset() {
  }

  @Test
  public void hset1() {
  }

  @Test
  public void hdel() {
  }

  @Test
  public void hHasKey() {
  }

  @Test
  public void hincr() {
  }

  @Test
  public void hdecr() {
  }

  @Test
  public void sGet() {
  }

  @Test
  public void sHasKey() {
  }

  @Test
  public void sSet() {
  }

  @Test
  public void sSetAndTime() {
  }

  @Test
  public void sGetSetSize() {
  }

  @Test
  public void setRemove() {
  }

  @Test
  public void lGet() {
  }

  @Test
  public void lGetListSize() {
  }

  @Test
  public void lGetIndex() {
  }

  @Test
  public void lSet() {
  }

  @Test
  public void lSet1() {
  }

  @Test
  public void lSet2() {
  }

  @Test
  public void lSet3() {
  }

  @Test
  public void lUpdateIndex() {
  }

  @Test
  public void lRemove() {
  }
}