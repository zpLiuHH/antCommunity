package life.zpliu.community.controller;

import life.zpliu.community.mapper.UserMapper;
import life.zpliu.community.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zpliu
 * @date 2019/6/29 18:31
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish() {

        return "publish";
    }

}
