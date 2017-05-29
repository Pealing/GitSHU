package org.gitshu.user.action.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;
import org.gitshu.user.action.UserRegister;
import org.gitshu.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Created by Lodour on 17/5/28 20:09.
 * 用户注册拦截器
 */
// 暂时不使用拦截器
@Deprecated
public class UserRegisterInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        UserRegister action = (UserRegister) actionInvocation.getAction();
        String username = action.getModel().getUsername();
        UserService userService = getUserService(actionInvocation);
        if (userService.chkUsername(username)) {
            action.addFieldError("model.username", "用户名已存在");
            return "input";
        }
        return actionInvocation.invoke();
    }

    private UserService getUserService(ActionInvocation actionInvocation) {
        ActionContext actionContext = actionInvocation.getInvocationContext();
        ServletContext context = (ServletContext) actionContext.get(StrutsStatics.SERVLET_CONTEXT);
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        return (UserService) ctx.getBean("userServiceImpl");
    }
}
