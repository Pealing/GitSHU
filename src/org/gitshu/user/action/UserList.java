package org.gitshu.user.action;

import org.gitshu.entity.UserEntity;
import org.gitshu.user.service.UserService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lodour on 17/5/27 01:54.
 * <p>
 * 用户相关动作
 */
@Controller
@Deprecated
public class UserList extends ActionVariableSupport {
    // 使用UserService进行事务请求
    private final UserService userService;

    // Action所使用的数据实体
    private List<UserEntity> userEntityList = new ArrayList<>();

    @Autowired
    public UserList(UserService userService) {
        this.userService = userService;
    }

    // 列举用户
    public String execute() throws Exception {
        userEntityList = userService.getAllUserEntities();
        httpServletRequest.setAttribute("tt", userEntityList);
        return SUCCESS;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
