package life.zpliu.community.provider;

import com.alibaba.fastjson.JSON;
import life.zpliu.community.dto.AccessTokenDTO;
import life.zpliu.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: liuzhipeng
 * @since: 2019/8/1
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDto) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        String url = "https://github.com/login/oauth/access_token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.print(response.body().string());
            String callBackStr = response.body().string();
            String[] split = callBackStr.split("&");
            String access_token = split[0].split("=")[1];
            return access_token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GitHubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.github.com/user?access_token";
        Request request = new Request.Builder()
                .url(url + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
            GitHubUser user = JSON.parseObject(response.body().string(), GitHubUser.class);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
