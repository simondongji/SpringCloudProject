package priv.simon.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by simon on 2018/9/25.
 */
@FeignClient(name = "provider")
public interface FeignService {
    @RequestMapping(value = "/getBookByName",method = RequestMethod.GET)
    String getBookByName(@RequestParam("id") String id);
}
