package org.gitshu.user.dao;

import org.gitshu.entity.UserEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/27 01:35.
 * <p>
 * 用户数据访问对象 - User Data Access Object
 * <p>
 * 封装用户数据的访问接口
 */
public interface UserDAO {

    /**
     * 创建新用户
     *
     * @param userEntity 用户实体
     */
    void create(UserEntity userEntity);

    /**
     * 更新用户登录时间
     *
     * @param id 登录用户
     */
    void updateLoginTime(int id);

    /**
     * 检测用户名和密码是否匹配
     *
     * @param username 用户名
     * @param password 密码
     * @return 匹配结果
     */
    boolean checkUsernameAndPassword(String username, String password);

    /**
     * 根据用户名获取用户ID
     *
     * @param username 用户名
     * @return 用户ID
     */
    int getIdByUsername(String username);


    /**
     * 获取所有用户实体
     *
     * @return 所有的用户实体
     */
    List<UserEntity> getAllUserEntities();

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity getByUsername(String username);

    /**
     * 检测用户是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    boolean chkUsername(String username);

    /**
     * 更新用户
     *
     * @param userEntity 用户实体
     */
    void update(UserEntity userEntity);

    /**
     * 根据ID获取用户
     *
     * @param id 用户ID
     * @return 用户实体
     */
    UserEntity getById(int id);
}
