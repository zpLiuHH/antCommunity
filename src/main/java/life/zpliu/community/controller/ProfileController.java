package life.zpliu.community.controller;

import life.zpliu.community.model.QuestionModel;
import life.zpliu.community.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zpliu
 * @date 2020/4/28 22:59
 */
@Controller
public class ProfileController {
    @GetMapping ("/profile/{action}")
    public String profile(
            @PathVariable(name="action") String action,
            Model model
    ){
        if("question".equals(action)){
            model.addAttribute("sectionName","我的问题");
            model.addAttribute("section","question");
        }else if ("replies".equals(action)){
            model.addAttribute("sectionName","最新回复");
            model.addAttribute("section","replies");
        }
        return "profile";
    }
}
