package org.gitshu.user.service;

import org.gitshu.entity.UserEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/27 01:23.
 * <p>
 * 用户业务对象
 * <p>
 * 封装用户相关的业务逻辑接口
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param userEntity 用户实体
     */
    void create(UserEntity userEntity);


    /**
     * 创建访客账户
     *
     * @param userEntity 用户实体
     */
    void createGuest(UserEntity userEntity);

    /**
     * 更新用户
     *
     * @param userEntity 用户实体
     */
    void update(UserEntity userEntity);

    /**
     * 登录用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 若登录成功则返回用户ID，否则返回-1
     */
    int login(String username, String password);

    /**
     * 检测用户名是否已存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    boolean chkUsername(String username);

    /**
     * 获取所有用户数据
     *
     * @return 所有的用户实体
     */
    List<UserEntity> getAllUserEntities();


    /**
     * 根据用户名获取用户实体
     *
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity getByUsername(String username);
}
