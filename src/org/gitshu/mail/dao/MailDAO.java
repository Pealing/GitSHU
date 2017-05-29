package org.gitshu.mail.dao;

import org.gitshu.entity.MailEntity;
import org.gitshu.entity.UserEntity;

import java.util.Collection;

/**
 * Created by Lodour on 17/5/29 20:04.
 * 邮件服务数据接口
 */
public interface MailDAO {

    /**
     * 创建新邮件
     *
     * @param from    发送用户
     * @param to      接受用户
     * @param content 内容
     */
    void create(UserEntity from, UserEntity to, String content);

    /**
     * 获取邮件实体
     *
     * @param id 邮件ID
     * @return 邮件实体
     */
    MailEntity getById(int id);

    /**
     * 获取某用户收到的所有邮件
     *
     * @param userEntity 用户实体
     * @return 所有邮件实体
     */
    Collection<MailEntity> getInbox(UserEntity userEntity);

    /**
     * 获取某用户发送的所有邮件
     *
     * @param userEntity 用户实体
     * @return 所有邮件实体
     */
    Collection<MailEntity> getOutbox(UserEntity userEntity);

    /**
     * 设置邮件状态
     *
     * @param id     邮件ID
     * @param status 邮件状态 [0]未读 [1]已读
     */
    void setRead(int id, int status);
}
