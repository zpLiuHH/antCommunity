package life.zpliu.community.dto;

import lombok.Data;

/**
 * @author: liuzhipeng
 * @since: 2019/8/2
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
