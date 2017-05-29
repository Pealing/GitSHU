package org.gitshu.mail.action;

import org.gitshu.entity.MailEntity;
import org.gitshu.mail.service.MailService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 21:27.
 * 获取收件箱
 * 结果保存在request的outbox中
 */
@Controller
public class Outbox extends ActionVariableSupport {
    private final MailService mailService;

    @Autowired
    public Outbox(MailService mailService) {
        this.mailService = mailService;
    }

    public String execute() {
        String username = (String) httpSession.get("username");
        List<MailEntity> mailEntityList = mailService.getOutbox(username);
        httpServletRequest.setAttribute("outbox", mailEntityList);
        return SUCCESS;
    }
}
