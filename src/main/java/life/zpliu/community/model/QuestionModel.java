package life.zpliu.community.model;

import lombok.Data;

/**
 * @author zpliu
 * @date 2020/2/14 16:07
 */
@Data
public class QuestionModel {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private Long gmtCreate;
    private Long gmtModified;
}
