package life.zpliu.community.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import life.zpliu.community.dto.AccessTokenDTO;
import life.zpliu.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

/**
 * @author zpliu
 * @date 2019/6/29 18:31
 */
@Controller
public class AuthorController {
    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        String client_id = "c65a2086684ea6420af8";
        String client_secret = "2197fdcbeee14e2d71f2b5f2cbe94c29b4377048";
        String redirect_uri = "http://localhost:8887/callback";
        AccessTokenDTO accessTokenDto = new AccessTokenDTO();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(client_id);
        accessTokenDto.setClient_secret(client_secret);
        accessTokenDto.setRedirect_uri(redirect_uri);
        gitHubProvider.getAccessToken(accessTokenDto);
        return "index";
    }

}
