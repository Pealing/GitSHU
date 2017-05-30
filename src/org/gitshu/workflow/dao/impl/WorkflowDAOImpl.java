package org.gitshu.workflow.dao.impl;

import org.gitshu.entity.WorkflowEntity;
import org.gitshu.utils.dao.DAOSupport;
import org.gitshu.workflow.dao.WorkflowDAO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Lodour on 17/5/30 00:41.
 * 工作流DAO的实现
 */
@Repository
@Transactional
public class WorkflowDAOImpl extends DAOSupport implements WorkflowDAO {

    protected WorkflowDAOImpl ( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    /**
     * 创建一个新结点
     *
     * @param workflowEntity 结点实体
     * @return 新建结点的ID
     */
    @Override
    public int create ( WorkflowEntity workflowEntity ) {
        workflowEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        getSession().save(workflowEntity);
        return getSession()
                .createQuery("select id from WorkflowEntity as w where w.projectByProject = :proj order by id desc")
                .setParameter("proj", workflowEntity.getProjectByProject())
                .getFirstResult();
    }

    /**
     * 更新一个结点
     *
     * @param workflowEntity 结点实体
     */
    @Override
    public void update ( WorkflowEntity workflowEntity ) {
        getSession().update(workflowEntity);
    }

    /**
     * 删除一个结点
     *
     * @param workflowId 结点编号
     */
    @Override
    public void delete ( int workflowId ) {
        getSession()
                .createQuery("delete from WorkflowEntity as u where u.id = :id")
                .setParameter("id", workflowId)
                .executeUpdate();
    }

    /**
     * 设置结点状态
     *
     * @param workflowId 结点ID
     * @param status     状态
     */
    @Override
    public void setStatus ( int workflowId, int status ) {
        getSession()
                .createQuery("update WorkflowEntity as u set u.status = :st where u.id = :id")
                .setParameter("st", status)
                .setParameter("id", workflowId)
                .executeUpdate();
    }

    /**
     * 根据ID获取结点实体
     *
     * @param workflowId 结点ID
     * @return 结点实体
     */
    @Override
    public WorkflowEntity getById ( int workflowId ) {
        return (WorkflowEntity) getSession()
                .createQuery("from WorkflowEntity w where w.id = :id")
                .setParameter("id", workflowId)
                .getSingleResult();
    }

    /**
     * 根据项目ID获取所属结点列表
     *
     * @param projectId 项目ID
     * @return 结点列表
     */
    @Override
    public List getByProjectId ( int projectId ) {
        return getSession()
                .createQuery("from WorkflowEntity  w where w.projectByProject.id = :id")
                .setParameter("id", projectId)
                .getResultList();
    }
}
