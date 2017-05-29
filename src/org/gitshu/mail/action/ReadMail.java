package org.gitshu.mail.action;

import org.gitshu.entity.MailEntity;
import org.gitshu.mail.service.MailService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/29 21:27.
 * 读取邮件内容
 * 结果保存在request的mail中
 */
@Controller
public class ReadMail extends ActionVariableSupport {
    private final MailService mailService;

    @Autowired
    public ReadMail(MailService mailService) {
        this.mailService = mailService;
    }

    public String execute() {
        String username = (String) httpSession.get("username");
        int mailEntityId = Integer.valueOf(httpServletRequest.getParameter("id"));
        MailEntity mailEntity = mailService.getById(mailEntityId);
        if (username.equals(mailEntity.getUserByReceiver().getUsername())) {
            httpServletRequest.setAttribute("mail", mailEntity.getContent());
            mailService.read(mailEntityId);
            return SUCCESS;
        }
        return ERROR;
    }
}
