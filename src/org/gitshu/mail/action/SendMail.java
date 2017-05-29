package org.gitshu.mail.action;

import org.gitshu.mail.service.MailService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import static java.lang.System.out;

/**
 * Created by Lodour on 17/5/29 21:27.
 * 发送邮件
 */
@Controller
public class SendMail extends ActionVariableSupport {
    private final MailService mailService;

    @Autowired
    public SendMail(MailService mailService) {
        this.mailService = mailService;
    }

    public String execute() {
        String author = (String) httpSession.get("username");
        out.print(author);
        String receiver = (String) httpServletRequest.getParameter("username");
        out.print(receiver);
        String content = (String) httpServletRequest.getParameter("content");
        try {
            mailService.send(author, receiver, content);
            return SUCCESS;
        } catch (Exception e) {
            httpServletRequest.setAttribute("result", "该用户不存在");
            return ERROR;
        }
    }
}
