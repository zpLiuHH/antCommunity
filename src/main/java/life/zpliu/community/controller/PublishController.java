package life.zpliu.community.controller;

import life.zpliu.community.mapper.QuestionMapper;
import life.zpliu.community.mapper.UserMapper;
import life.zpliu.community.model.QuestionModel;
import life.zpliu.community.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zpliu
 * @date 2019/6/29 18:31
 */
@Controller
//@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish() {

        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            HttpServletRequest request,
            Model model
    ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        UserModel user = (UserModel) request.getSession().getAttribute("user");
        if (user != null) {
            request.getSession().setAttribute("user", user);
        } else {
            return "redirect:/";
        }
        if(user == null){
            model.addAttribute("error","用户未登录");
            return  "publish";
        }

        if(title==null||title.equals("")){

            model.addAttribute("error","标题不能为空！");
            return "publish";
        }
        if(description==null||description.equals("")){

            model.addAttribute("error","问题描述不能为空！");
            return "publish";
        }
        if(tag==null||tag.equals("")){

            model.addAttribute("error","标签不能为空！");
            return "publish";
        }
        QuestionModel question = new QuestionModel();

        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(Integer.valueOf(user.getAccountId()));
        question.setGmtCreat(System.currentTimeMillis());
        questionMapper.insert(question);
        return "publish";
    }

}
