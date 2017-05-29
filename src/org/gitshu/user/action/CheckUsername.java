package org.gitshu.user.action;

import org.gitshu.user.service.UserService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * Created by Lodour on 17/5/29 00:53.
 * 检测用户名是否存在
 */
@Controller
public class CheckUsername extends ActionVariableSupport {
    private final UserService userService;

    @Autowired
    public CheckUsername(UserService userService) {
        this.userService = userService;
    }

    public String execute() throws Exception {
        String username = httpServletRequest.getParameter("username");
        httpServletRequest.setAttribute("result", userService.chkUsername(username));
        return "done";
    }
}
