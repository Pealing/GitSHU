package org.gitshu.mail.service.impl;

import org.gitshu.entity.MailEntity;
import org.gitshu.entity.UserEntity;
import org.gitshu.mail.dao.MailDAO;
import org.gitshu.mail.service.MailService;
import org.gitshu.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Lodour on 17/5/29 20:03.
 * 邮件服务的实现
 */
@Service
public class MailServiceImpl implements MailService {

    /**
     * 使用MailDAO进行服务的实现
     */
    private final MailDAO mailDAO;
    private final UserDAO userDAO;

    @Autowired
    public MailServiceImpl(MailDAO mailDAO, UserDAO userDAO) {
        this.mailDAO = mailDAO;
        this.userDAO = userDAO;
    }

    /**
     * 发送邮件
     *
     * @param from    发送人
     * @param to      接收人
     * @param content 内容
     */
    @Override
    public void send(String from, String to, String content) {
        UserEntity userEntityFrom = userDAO.getByUsername(from);
        UserEntity userEntityTo = userDAO.getByUsername(to);
        mailDAO.create(userEntityFrom, userEntityTo, content);
    }

    /**
     * 群发邮件
     *
     * @param from    发送邮件的用户名
     * @param group   接受邮件的用户名
     * @param content 内容
     */
    @Override
    public void sendGroup(String from, String[] group, String content) {
        for (String to : group) {
            send(from, to, content);
        }
    }

    /**
     * 标记某邮件为已阅读
     *
     * @param id 邮件ID
     */
    @Override
    public void read(int id) {
        mailDAO.setRead(id, 1);
    }

    /**
     * 标记邮件为未读状态
     *
     * @param id 邮件ID
     */
    @Override
    public void unread(int id) {
        mailDAO.setRead(id, 0);
    }

    /**
     * 获取用户未读邮件列表
     *
     * @param user 用户名
     * @return 未读邮件实体列表
     */
    @Override
    public List<MailEntity> getUnread(String user) {
        List<MailEntity> mailEntityListAll = getInbox(user);
        List<MailEntity> mailEntityListUnread = new ArrayList<>();
        for (MailEntity mailEntity : mailEntityListAll) {
            if (mailEntity.getIsRead() == 0x1)
                mailEntityListUnread.add(mailEntity);
        }
        return mailEntityListUnread;
    }

    /**
     * 获取用户已读邮件列表
     *
     * @param user 用户名
     * @return 已读邮件列表
     */
    @Override
    public List<MailEntity> getRead(String user) {
        List<MailEntity> mailEntityListAll = getInbox(user);
        List<MailEntity> mailEntityListUnread = new ArrayList<>();
        for (MailEntity mailEntity : mailEntityListAll) {
            if (mailEntity.getIsRead() == 0x0)
                mailEntityListUnread.add(mailEntity);
        }
        return mailEntityListUnread;
    }

    /**
     * 获取用户所有收到邮件列表
     *
     * @param user 用户名
     * @return 所有邮件列表
     */
    @Override
    public List<MailEntity> getInbox(String user) {
        UserEntity userEntity = userDAO.getByUsername(user);
        Collection<MailEntity> mailEntityCollection = mailDAO.getInbox(userEntity);
        return (List<MailEntity>) mailEntityCollection;
    }

    /**
     * 获取用户发送邮件列表
     *
     * @param author 用户
     * @return 发送邮件列表
     */
    @Override
    public List<MailEntity> getOutbox(String author) {
        UserEntity userEntity = userDAO.getByUsername(author);
        Collection<MailEntity> mailEntityCollection = mailDAO.getOutbox(userEntity);
        return (List<MailEntity>) mailEntityCollection;
    }

    /**
     * 获取邮件实体
     *
     * @param id 邮件ID
     * @return 邮件实体
     */
    @Override
    public MailEntity getById(int id) {
        return mailDAO.getById(id);
    }

}
