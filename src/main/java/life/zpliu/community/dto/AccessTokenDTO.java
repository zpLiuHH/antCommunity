package life.zpliu.community.dto;

import lombok.Data;

/**
 * @author: liuzhipeng
 * @since: 2019/8/1
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
