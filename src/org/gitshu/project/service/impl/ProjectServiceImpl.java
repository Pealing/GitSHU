package org.gitshu.project.service.impl;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.entity.UserEntity;
import org.gitshu.project.dao.ProjectDAO;
import org.gitshu.project.service.ProjectService;
import org.gitshu.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 22:16.
 * 项目服务的实现
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDAO projectDAO;
    private final UserDAO userDAO;

    @Autowired
    public ProjectServiceImpl ( ProjectDAO projectDAO, UserDAO userDAO ) {
        this.projectDAO = projectDAO;
        this.userDAO = userDAO;
    }

    /**
     * 创建新项目
     *
     * @param username      创建者用户名
     * @param projectEntity 创建的项目实体
     */
    @Override
    public void create ( String username, ProjectEntity projectEntity ) {
        UserEntity userEntity = userDAO.getByUsername(username);
        projectEntity.setUserByCreateBy(userEntity);
        projectDAO.create(projectEntity);
    }

    /**
     * 更新项目
     *
     * @param projectEntity 更新的项目实体
     */
    @Override
    public void update ( ProjectEntity projectEntity ) {
        projectDAO.update(projectEntity);
    }

    /**
     * 根据ID获取项目
     *
     * @param id 项目ID
     * @return 项目实体
     */
    @Override
    public ProjectEntity getById ( int id ) {
        return projectDAO.getById(id);
    }

    @Override
    public List<ProjectEntity> getAllProjectEntities () {
        return projectDAO.getAllProjectEntities();
    }

}
