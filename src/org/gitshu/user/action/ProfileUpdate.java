package org.gitshu.user.action;

import com.opensymphony.xwork2.ModelDriven;
import org.gitshu.entity.UserEntity;
import org.gitshu.user.service.UserService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Pealing on 2017/5/29.
 * 修改用户个人信息
 */
@Controller
public class ProfileUpdate extends ActionVariableSupport implements ModelDriven<UserEntity> {
    // 使用UserService进行事务请求
    private final UserService userService;

    // Action所涉及的用户实体
    private UserEntity userEntity;

    @Autowired
    public ProfileUpdate(UserService userService) {
        this.userService = userService;
        userEntity = new UserEntity();
    }

    public String execute() {
        try {
            String username = (String) httpSession.get("username");
            UserEntity user = userService.getByUsername(username);
            if (userEntity.getEmail() != null) {
                user.setEmail(userEntity.getEmail());
            }
            if (userEntity.getMobile() != null) {
                user.setMobile(userEntity.getMobile());
            }
            if (userEntity.getInfo() != null) {
                user.setInfo(userEntity.getInfo());
            }
            userService.update(user);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return ERROR;
        }
    }

    @Override
    public UserEntity getModel() {
        return userEntity;
    }
}
