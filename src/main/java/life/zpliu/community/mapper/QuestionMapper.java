package life.zpliu.community.mapper;

import life.zpliu.community.dto.QuestionDTO;
import life.zpliu.community.model.QuestionModel;
import life.zpliu.community.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: liuzhipeng
 * @since: 2020/2/14
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,tag,creator,gmt_creat,gmt_modified) values (#{title},#{description},#{tag},#{creator},#{gmtCreat},#{gmtModified})")
     void insert(QuestionModel questionModel);
    @Select("select * from question")
    List<QuestionModel> list();
    @Select("select * from question order by id limit #{offset},#{pageSize}")
    List<QuestionModel> listByPage(@Param(value = "offset")Integer offset,@Param(value ="pageSize")Integer pageSize);
    @Select("select count(1) from question")
    Integer queryCount();
    @Select("select count(1) from question where creator= #{userId}")
    Integer queryCountByUserId(@Param(value = "userId")String userId);

    @Select("select * from question  where creator= #{userId} order by id limit #{offset},#{pageSize}")
    List<QuestionModel> listByUserId(@Param(value = "userId")String userId,@Param(value = "offset")Integer offset,@Param(value ="pageSize")Integer pageSize);
    @Select("select * from question where id = #{id}")
    QuestionModel getById(Integer id);

//    @Select("select * from question where  = #{}")
//    UserModel findBy(@Param("") String token);
}
