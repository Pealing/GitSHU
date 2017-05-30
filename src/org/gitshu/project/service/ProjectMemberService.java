package org.gitshu.project.service;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.entity.UserEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 22:11.
 * 项目成员Service
 */
public interface ProjectMemberService {

    /**
     * 添加项目成员
     *
     * @param projectId 项目ID
     * @param username  成员用户名
     */
    void addMember ( int projectId, String username );

    /**
     * 添加多个项目成员
     *
     * @param projectId 项目ID
     * @param group     成员用户名数组
     */
    void addMembers ( int projectId, String[] group );

    /**
     * 删除项目成员
     *
     * @param projectId 项目ID
     * @param username  成员用户名
     */
    void removeMember ( int projectId, String username );

    /**
     * 删除多个项目成员
     *
     * @param projectId 项目ID
     * @param group     成员用户名
     */
    void removeMembers ( int projectId, String[] group );

    /**
     * 获取项目成员
     *
     * @param projectId 项目ID
     * @return 项目成员实体
     */
    List<UserEntity> getMembers ( int projectId );

    /**
     * 获取所有的项目实体
     *
     * @return 项目实体列表
     */
    List<ProjectEntity> getAllProjects ();

    /**
     * 获取用户所参加的项目
     *
     * @param username 用户名
     * @return 用户参加的项目实体列表
     */
    List<ProjectEntity> getJoinedProjects ( String username );
}
