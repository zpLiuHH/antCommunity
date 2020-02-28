package life.zpliu.community.dto;

import life.zpliu.community.model.UserModel;
import lombok.Data;

/**
 * @author zpliu
 * @date 2020/2/14 16:07
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private Long gmtCreat;
    private Long gmtModified;
    private UserModel user;
}
