package org.gitshu.workflow.service.impl;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.entity.WorkflowEntity;
import org.gitshu.project.dao.ProjectDAO;
import org.gitshu.workflow.dao.WorkflowDAO;
import org.gitshu.workflow.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lodour on 17/5/30 00:37.
 * 工作流Service的实现
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowDAO workflowDAO;
    private final ProjectDAO projectDAO;

    @Autowired
    public WorkflowServiceImpl ( WorkflowDAO workflowDAO, ProjectDAO projectDAO ) {
        this.workflowDAO = workflowDAO;
        this.projectDAO = projectDAO;
    }


    /**
     * 新建工作流结点
     *
     * @param projectId 从属项目ID
     * @param title     结点标题
     * @param info      结点介绍
     * @return 新建结点的ID
     */
    @Override
    public int create ( int projectId, String title, String info ) {
        ProjectEntity projectEntity = projectDAO.getById(projectId);
        WorkflowEntity workflowEntity = new WorkflowEntity();
        workflowEntity.setTitle(title);
        workflowEntity.setInfo(info);
        workflowEntity.setProjectByProject(projectEntity);
        return workflowDAO.create(workflowEntity);
    }

    /**
     * 更新一个结点
     *
     * @param workflowEntity 工作流结点实体
     */
    @Override
    public void update ( WorkflowEntity workflowEntity ) {
        workflowDAO.update(workflowEntity);
    }

    /**
     * 删除一个结点
     *
     * @param workflowId 工作流结点实体
     */
    @Override
    public void delete ( int workflowId ) {
        workflowDAO.delete(workflowId);
    }

    /**
     * 标记一个结点为完成状态
     *
     * @param workflowId 结点ID
     */
    @Override
    public void setFinished ( int workflowId ) {
        workflowDAO.setStatus(workflowId, 2);
    }

    /**
     * 标记一个结点为未完成状态
     *
     * @param workflowId 结点ID
     */
    @Override
    public void setUnfinished ( int workflowId ) {
        workflowDAO.setStatus(workflowId, 0);
    }

    /**
     * 标记一个结点为进行中状态
     *
     * @param workflowId 结点ID
     */
    @Override
    public void setProcessing ( int workflowId ) {
        workflowDAO.setStatus(workflowId, 1);
    }

    /**
     * 根据ID获取一个结点实体
     *
     * @param workflowId 结点ID
     * @return 结点实体
     */
    @Override
    public WorkflowEntity getById ( int workflowId ) {
        return workflowDAO.getById(workflowId);
    }

    /**
     * 获取一个项目的所有节点
     *
     * @param projectId 项目ID
     * @return 所有节点实体列表
     */
    @Override
    public List<WorkflowEntity> getByProjectId ( int projectId ) {
        return workflowDAO.getByProjectId(projectId);
    }
}
