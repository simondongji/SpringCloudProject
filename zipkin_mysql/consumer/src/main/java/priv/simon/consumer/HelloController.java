package priv.simon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by simon on 2018/9/25.
 */
@RestController
public class HelloController {
    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "getBookName")
    public String getBookName(@RequestParam("id") String id){
        return feignService.getBookByName(id);
    }
}
