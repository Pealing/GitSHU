package org.gitshu.mail.dao.impl;

import org.gitshu.entity.MailEntity;
import org.gitshu.entity.UserEntity;
import org.gitshu.mail.dao.MailDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Lodour on 17/5/29 20:05.
 * 邮件数据接口的实现
 */
@Repository
@Transactional
public class MailDAOImpl implements MailDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public MailDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 创建新邮件
     *
     * @param from    发送用户
     * @param to      接受用户
     * @param content 内容
     */
    @Override
    public void create(UserEntity from, UserEntity to, String content) {
        MailEntity mailEntity = new MailEntity();
        mailEntity.setUserByAuthor(from);
        mailEntity.setUserByReceiver(to);
        mailEntity.setContent(content);
        mailEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        getSession().save(mailEntity);
    }

    /**
     * 获取邮件实体
     *
     * @param id 邮件ID
     * @return 邮件实体
     */
    @Override
    public MailEntity getById(int id) {
        return (MailEntity) getSession()
                .createQuery("from MailEntity m where m.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * 获取某用户收到的所有邮件
     *
     * @param userEntity 用户实体
     * @return 所有邮件实体
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<MailEntity> getInbox(UserEntity userEntity) {
        return (Collection<MailEntity>) getSession()
                .createQuery("from MailEntity m where m.userByReceiver = :receiver")
                .setParameter("receiver", userEntity)
                .getResultList();
    }

    /**
     * 获取某用户发送的所有邮件
     *
     * @param userEntity 用户实体
     * @return 所有邮件实体
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<MailEntity> getOutbox(UserEntity userEntity) {
        return (Collection<MailEntity>) getSession()
                .createQuery("from MailEntity m where m.userByAuthor = :author")
                .setParameter("author", userEntity)
                .getResultList();
    }

    /**
     * 设置邮件状态
     *
     * @param id     邮件ID
     * @param status 邮件状态 [0]未读 [1]已读
     */
    @Override
    public void setRead(int id, int status) {
        MailEntity mailEntity = getById(id);
        mailEntity.setIsRead((byte) status);
        getSession().update(mailEntity);
    }
}
