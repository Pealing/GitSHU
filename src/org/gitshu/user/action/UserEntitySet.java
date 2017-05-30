package org.gitshu.user.action;

import org.gitshu.entity.UserEntity;
import org.gitshu.user.service.UserService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/30 03:40.
 * 设置登录用户实体
 */
@Controller
public class UserEntitySet extends ActionVariableSupport {

    private final UserService userService;

    @Autowired
    public UserEntitySet ( UserService userService ) {
        this.userService = userService;
    }

    public String execute () {
        String username = (String) httpSession.get("username");
        UserEntity userEntity = userService.getByUsername(username);
        httpServletRequest.setAttribute("userEntity", userEntity);
        return SUCCESS;
    }
}
