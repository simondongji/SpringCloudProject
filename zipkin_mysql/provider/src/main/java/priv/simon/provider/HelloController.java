package priv.simon.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by simon on 2018/9/25.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/getBookByName")
    public String getNameById(@RequestParam("id") String id){
        String bookName = "";
        switch (id){
            case "1" :
                bookName = "Java";
                break;
            case "2" :
                bookName = "C++";
                break;
            default:
                bookName = "phython";
        }
        return bookName;
    }
}
