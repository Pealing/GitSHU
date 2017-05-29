package org.gitshu.user.action;

import com.opensymphony.xwork2.ModelDriven;
import org.gitshu.entity.UserEntity;
import org.gitshu.user.service.UserService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/28 19:09.
 * 用户登录
 */
@Controller
public class UserLogin extends ActionVariableSupport implements ModelDriven<UserEntity> {
    // 使用UserService进行事务请求
    private final UserService userService;

    // Action所涉及的用户实体
    private UserEntity userEntity;

    @Autowired
    public UserLogin(UserService userService) {
        this.userService = userService;
        userEntity = new UserEntity();
    }

    // 登录
    public String execute() {
        int result = userService.login(userEntity.getUsername(), userEntity.getPassword());
        if (result != -1) {
            httpSession.put("username", userEntity.getUsername());
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public UserEntity getModel() {
        return userEntity;
    }
}
