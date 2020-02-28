package life.zpliu.community.controller;

import life.zpliu.community.dto.PagenationDTO;
import life.zpliu.community.dto.QuestionDTO;
import life.zpliu.community.mapper.QuestionMapper;
import life.zpliu.community.mapper.UserMapper;
import life.zpliu.community.model.QuestionModel;
import life.zpliu.community.model.UserModel;
import life.zpliu.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zpliu
 * @date 2019/6/29 18:31
 */
@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "offset", defaultValue = "1") Integer offset,
                        @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize,
                        HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    UserModel user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
       /* List<QuestionDTO> list = questionService.list();
        if (list != null && list.size() > 0) {
            model.addAttribute("list", list);
        }*/
        PagenationDTO pagenation = questionService.listByPage(offset, pageSize);
        model.addAttribute("pagenation", pagenation);
        return "index";
    }

}
