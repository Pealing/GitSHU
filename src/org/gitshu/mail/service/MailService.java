package org.gitshu.mail.service;

import org.gitshu.entity.MailEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 11:56.
 * 邮件服务接口
 */
public interface MailService {
    /**
     * 发送邮件
     *
     * @param from    发送人
     * @param to      接收人
     * @param content 内容
     */
    void send(String from, String to, String content);

    /**
     * 群发邮件
     *
     * @param from    发送邮件的用户名
     * @param group   接受邮件的用户名
     * @param content 内容
     */
    void sendGroup(String from, String[] group, String content);

    /**
     * 标记某邮件为已阅读
     *
     * @param id 邮件ID
     */
    void read(int id);

    /**
     * 标记邮件为未读状态
     *
     * @param id 邮件ID
     */
    void unread(int id);

    /**
     * 获取用户未读邮件列表
     *
     * @param user 用户名
     * @return 未读邮件实体列表
     */
    List<MailEntity> getUnread(String user);

    /**
     * 获取用户已读邮件列表
     *
     * @param user 用户名
     * @return 已读邮件列表
     */
    List<MailEntity> getRead(String user);

    /**
     * 获取用户所有邮件列表
     *
     * @param user 用户名
     * @return 所有邮件列表
     */
    List<MailEntity> getInbox(String user);

    /**
     * 获取用户发送邮件列表
     *
     * @param author 用户
     * @return 发送邮件列表
     */
    List<MailEntity> getOutbox(String author);

    /**
     * 获取邮件实体
     *
     * @param id 邮件ID
     * @return 邮件实体
     */
    MailEntity getById(int id);
}
