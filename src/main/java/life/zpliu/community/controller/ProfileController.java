package life.zpliu.community.controller;

import life.zpliu.community.dto.PagenationDTO;
import life.zpliu.community.model.UserModel;
import life.zpliu.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zpliu
 * @date 2020/4/28 22:59
 */
@Controller
public class ProfileController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(
            @PathVariable(name = "action") String action,
            Model model,
            @RequestParam(name = "offset", defaultValue = "1") Integer offset,
            @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize,
            HttpServletRequest request
    ) {
        if ("question".equals(action)) {
            model.addAttribute("sectionName", "我的问题");
            model.addAttribute("section", "question");
        } else if ("replies".equals(action)) {
            model.addAttribute("sectionName", "最新回复");
            model.addAttribute("section", "replies");
        }

        UserModel user = (UserModel) request.getSession().getAttribute("user");
        if (user != null) {
            request.getSession().setAttribute("user", user);
        } else {
            return "redirect:/";
        }
        PagenationDTO pagenation = questionService.listByUserId(user.getAccountId(), offset, pageSize);
        model.addAttribute("pagenation", pagenation);

        return "profile";
    }
}
