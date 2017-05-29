package org.gitshu.user.dao.impl;

import org.gitshu.entity.UserEntity;
import org.gitshu.user.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Lodour on 17/5/27 01:39.
 * <p>
 * 用户数据访问对象的一种实现 - User Data Access Object Implementation
 * <p>
 * 这种实现方式是官方文档提倡的
 * http://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/html/orm.html#orm-hibernate-straight
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 创建新用户
     *
     * @param userEntity 用户实体
     */

    @Override
    public void create(UserEntity userEntity) {
        assert !"".equals(userEntity.getUsername());
        assert !"".equals(userEntity.getPassword());
        assert !"".equals(userEntity.getRealName());
        userEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        getSession().save(userEntity);
    }

    /**
     * 更新用户登录时间
     *
     * @param id 登录用户
     */
    @Override
    public void updateLoginTime(int id) {
        getSession()
                .createQuery("update UserEntity u set u.lastLogin = current_timestamp  where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * 检测用户名和密码是否匹配
     *
     * @param username 用户名
     * @param password 密码
     * @return 匹配结果
     */
    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        try {
            getSession()
                    .createQuery("from UserEntity u where u.username = :username and u.password = :password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    /**
     * 根据用户名获取用户ID
     *
     * @param username 用户名
     * @return 用户ID
     */
    @Override
    public int getIdByUsername(String username) {
        return getByUsername(username).getId();
    }

    /**
     * 获取所有用户实体
     *
     * @return 所有的用户实体
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUserEntities() {
        return (List<UserEntity>) getSession()
                .createQuery("from UserEntity").getResultList();
    }

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    @Override
    public UserEntity getByUsername(String username) {
        return (UserEntity) getSession()
                .createQuery("from UserEntity u where u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    /**
     * 检测用户是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    @Override
    public boolean chkUsername(String username) {
        try {
            getByUsername(username);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    /**
     * 更新用户
     *
     * @param userEntity 用户实体
     */
    @Override
    public void update(UserEntity userEntity) {
        getSession().update(userEntity);
    }

    /**
     * 根据ID获取用户
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @Override
    public UserEntity getById(int id) {
        return (UserEntity) getSession()
                .createQuery("from UserEntity where id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }
}
