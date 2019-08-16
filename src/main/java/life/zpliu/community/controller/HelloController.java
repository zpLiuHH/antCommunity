package life.zpliu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zpliu
 * @date 2019/6/29 18:31
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String index(){
        return "hello";
    }

}
