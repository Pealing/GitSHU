package org.gitshu.project.dao;

import org.gitshu.entity.ProjectEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 21:54.
 * 项目DAO接口
 */
public interface ProjectDAO {

    /**
     * 创建项目
     *
     * @param projectEntity 项目实体
     */
    void create ( ProjectEntity projectEntity );


    /**
     * 更新项目
     *
     * @param projectEntity 项目实体
     */
    void update ( ProjectEntity projectEntity );

    /**
     * 根据ID获取项目实体
     *
     * @param id 项目ID
     * @return 项目实体
     */
    ProjectEntity getById ( int id );

    List<ProjectEntity> getAllProjectEntities ();

    List<ProjectEntity> getJoinedProjects ( String username );
}
