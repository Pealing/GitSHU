package org.gitshu.project.dao.impl;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.entity.ProjectUserEntity;
import org.gitshu.entity.UserEntity;
import org.gitshu.project.dao.ProjectMemberDAO;
import org.gitshu.utils.dao.DAOSupport;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by Lodour on 17/5/29 22:19.
 * ProjectMemberDAO的实现
 */
@Repository
@Transactional
public class ProjectMemberDAOImpl extends DAOSupport implements ProjectMemberDAO {
    @Autowired
    protected ProjectMemberDAOImpl ( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    /**
     * 添加项目成员
     *
     * @param projectEntity 项目实体
     * @param userEntity    用户实体
     */
    @Override
    public void add ( ProjectEntity projectEntity, UserEntity userEntity ) {
        ProjectUserEntity projectUserEntity = new ProjectUserEntity();
        projectUserEntity.setProjectByProject(projectEntity);
        projectUserEntity.setUserByUser(userEntity);
        projectUserEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        getSession().save(projectUserEntity);
    }
}
