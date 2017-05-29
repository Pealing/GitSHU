package org.gitshu.user.action;

import com.opensymphony.xwork2.ModelDriven;
import org.gitshu.entity.UserEntity;
import org.gitshu.user.service.UserService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Pealing on 2017/5/29.
 */
@Controller
public class PasswordReset extends ActionVariableSupport{
    // 使用UserService进行事务请求
    private final UserService userService;

    @Autowired
    public PasswordReset(UserService userService) {
        this.userService = userService;
    }
    public String execute()
    {
        String username = (String)httpSession.get("username");
        System.out.println(username);
        UserEntity user = userService.getByUsername(username);
        if(user.getPassword().equals(httpServletRequest.getParameter("oldPassword")))
        {
            user.setPassword(httpServletRequest.getParameter("newPassword"));
            userService.update(user);
            httpServletRequest.setAttribute("result", true);
            return SUCCESS;
        }
        else
        {
            httpServletRequest.setAttribute("result", false);
            return ERROR;
        }
    }
}
