package org.gitshu.user.action;

import org.gitshu.utils.action.ActionVariableSupport;

/**
 * Created by Lodour on 17/5/28 19:09.
 * 用户注销
 */
public class UserLogout extends ActionVariableSupport {
    public String execute() {
        httpSession.put("username", "");
        return SUCCESS;
    }
}
