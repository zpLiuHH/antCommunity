package life.zpliu.community.mapper;

import life.zpliu.community.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: liuzhipeng
 * @since: 2019/8/14
 */
@Mapper
public interface  UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
     void insert (UserModel userModel);

    @Select("select * from user where token = #{token}")
    UserModel findByToken(@Param("token")  String token);

    @Select("select * from user where account_id = #{id}")
    List<UserModel> findbyId(@Param("id")Integer creator);

}
