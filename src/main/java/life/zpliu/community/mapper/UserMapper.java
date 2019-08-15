package life.zpliu.community.mapper;

import life.zpliu.community.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: liuzhipeng
 * @since: 2019/8/14
 */
@Mapper
public interface  UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
     void insert (UserModel userModel);


}
