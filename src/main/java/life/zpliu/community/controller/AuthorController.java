package life.zpliu.community.controller;

import life.zpliu.community.dto.AccessTokenDTO;
import life.zpliu.community.dto.GitHubUser;
import life.zpliu.community.mapper.UserMapper;
import life.zpliu.community.model.UserModel;
import life.zpliu.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author zpliu
 * @date 2019/6/29 18:31
 */
@Controller
public class AuthorController {
    @Autowired
    private GitHubProvider gitHubProvider;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String redirect_uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDto = new AccessTokenDTO();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(client_id);
        accessTokenDto.setClient_secret(client_secret);
        accessTokenDto.setRedirect_uri(redirect_uri);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        if (user != null) {
            //登录成功 写cookie和session
            UserModel userModel = new UserModel();
            String token = UUID.randomUUID().toString();
            userModel.setToken(token);
            userModel.setName(user.getName());
            userModel.setAccountId(user.getId().toString());
            userModel.setGmtCreate(System.currentTimeMillis());
            userModel.setGmtModified(userModel.getGmtCreate());
            userModel.setAvatarUrl(user.getAvatarUrl());
            userMapper.insert(userModel);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        } else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }

}
