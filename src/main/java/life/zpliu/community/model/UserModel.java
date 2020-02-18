package life.zpliu.community.model;

import lombok.Data;

/**
 * @author: liuzhipeng
 * @since: 2019/8/14
 */
@Data
public class UserModel {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
