package life.zpliu.community.controller;

import life.zpliu.community.dto.PagenationDTO;
import life.zpliu.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zpliu
 * @date 2019/6/29 18:31
 */
@Controller
public class IndexController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "offset", defaultValue = "1") Integer offset,
                        @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize,
                        Model model){
//                        HttpServletRequest request, Model model,
//                        @CookieValue(name ="token") String token) {

/*        //use  @CookieValue
            if(token != null && !token.equals("")){
                UserModel user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
            }*/

       /* List<QuestionDTO> list = questionService.list();
        if (list != null && list.size() > 0) {
            model.addAttribute("list", list);
        }*/
        PagenationDTO pagenation = questionService.listByPage(offset, pageSize);
        model.addAttribute("pagenation", pagenation);
        return "index";
    }

}
