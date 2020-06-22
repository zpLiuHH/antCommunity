package life.zpliu.community.service;

import life.zpliu.community.mapper.UserMapper;
import life.zpliu.community.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zpliu
 * @date 2020/5/8 14:29
 */
@Service
public interface UserService {

//    @Autowired
//    private UserMapper userMapper;

//    public void createOrUpdate(UserModel user) {
//        UserExample userExample = new UserExample();
//        userExample.createCriteria()
//                .andAccountIdEqualTo(user.getAccountId());
//        List<UserModel> users = userMapper.selectByExample(userExample);
//        if (users.size() == 0) {
//            // 插入
//            user.setGmtCreate(System.currentTimeMillis());
//            user.setGmtModified(user.getGmtCreate());
//            userMapper.insert(user);
//        } else {
//            //更新
//            UserModel dbUser = users.get(0);
//            UserModel updateUser = new UserModel();
//            updateUser.setGmtModified(System.currentTimeMillis());
//            updateUser.setAvatarUrl(user.getAvatarUrl());
//            updateUser.setName(user.getName());
//            updateUser.setToken(user.getToken());
//            UserExample example = new UserExample();
//            example.createCriteria()
//                    .andIdEqualTo(dbUser.getId());
//            userMapper.updateByExampleSelective(updateUser, example);
//        }
//    }
}
