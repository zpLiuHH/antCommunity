package life.zpliu.community.mapper;

import life.zpliu.community.model.QuestionModel;
import life.zpliu.community.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: liuzhipeng
 * @since: 2020/2/14
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,tag,creator,gmt_creat,gmt_modified) values (#{title},#{description},#{tag},#{creator},#{gmtCreate},#{gmtModified})")
     void insert(QuestionModel questionModel);

//    @Select("select * from question where  = #{}")
//    UserModel findBy(@Param("") String token);
}
