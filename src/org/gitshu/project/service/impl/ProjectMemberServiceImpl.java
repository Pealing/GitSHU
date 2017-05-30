package org.gitshu.project.service.impl;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.entity.UserEntity;
import org.gitshu.project.dao.ProjectDAO;
import org.gitshu.project.dao.ProjectMemberDAO;
import org.gitshu.project.service.ProjectMemberService;
import org.gitshu.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 23:19.
 * 项目成员Service的实现
 */
@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    private final UserDAO userDAO;
    private final ProjectDAO projectDAO;
    private final ProjectMemberDAO projectMemberDAO;

    @Autowired
    public ProjectMemberServiceImpl ( UserDAO userDAO, ProjectDAO projectDAO, ProjectMemberDAO projectMemberDAO ) {
        this.userDAO = userDAO;
        this.projectDAO = projectDAO;
        this.projectMemberDAO = projectMemberDAO;
    }

    /**
     * 添加项目成员
     *
     * @param projectId 项目ID
     * @param username  成员用户名
     */
    @Override
    public void addMember ( int projectId, String username ) {
        ProjectEntity projectEntity = projectDAO.getById(projectId);
        UserEntity userEntity = userDAO.getByUsername(username);
        projectMemberDAO.add(projectEntity, userEntity);
    }

    /**
     * 添加多个项目成员
     *
     * @param projectId 项目ID
     * @param group     成员用户名数组
     */
    @Override
    public void addMembers ( int projectId, String[] group ) {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除项目成员
     *
     * @param projectId 项目ID
     * @param username  成员用户名
     */
    @Override
    public void removeMember ( int projectId, String username ) {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除多个项目成员
     *
     * @param projectId 项目ID
     * @param group     成员用户名
     */
    @Override
    public void removeMembers ( int projectId, String[] group ) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取项目成员
     *
     * @param projectId 项目ID
     * @return 项目成员实体
     */
    @Override
    public List<UserEntity> getMembers ( int projectId ) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取所有的项目实体
     *
     * @return 项目实体列表
     */
    @Override
    public List<ProjectEntity> getAllProjects () {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取用户所参加的项目
     *
     * @param username 用户名
     * @return 用户参加的项目实体列表
     */
    @Override
    public List<ProjectEntity> getJoinedProjects ( String username ) {
        return projectDAO.getJoinedProjects(username);
    }
}
