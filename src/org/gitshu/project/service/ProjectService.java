package org.gitshu.project.service;

import org.gitshu.entity.ProjectEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 21:58.
 * 项目服务接口
 */
public interface ProjectService {

    /**
     * 创建新项目
     *
     * @param username      创建者用户名
     * @param projectEntity 创建的项目实体
     */
    void create ( String username, ProjectEntity projectEntity );

    /**
     * 更新项目
     *
     * @param projectEntity 更新的项目实体
     */
    void update ( ProjectEntity projectEntity );

    /**
     * 根据ID获取项目
     *
     * @param id 项目ID
     * @return 项目实体
     */
    ProjectEntity getById ( int id );

    List<ProjectEntity> getAllProjectEntities ();
}
