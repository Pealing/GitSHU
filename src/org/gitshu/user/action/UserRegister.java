package org.gitshu.user.action;

import com.opensymphony.xwork2.ModelDriven;
import org.gitshu.entity.UserEntity;
import org.gitshu.user.service.UserService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/28 19:09.
 * 用户身份相关的动作
 * 包括注册、登录、注销
 */
@Controller
public class UserRegister extends ActionVariableSupport implements ModelDriven<UserEntity> {
    // 使用UserService进行事务请求
    private final UserService userService;

    // Action所涉及的用户实体
    private UserEntity userEntity;

    @Autowired
    public UserRegister(UserService userService) {
        this.userService = userService;
        userEntity = new UserEntity();
    }

    // 注册
    public String execute() throws Exception {
        try {
            userService.createGuest(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public UserEntity getModel() {
        return userEntity;
    }
}
