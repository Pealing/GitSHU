package org.gitshu.workflow.service;

import org.gitshu.entity.WorkflowEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/30 00:29.
 * 工作流Service
 */
public interface WorkflowService {
    /**
     * 新建工作流结点
     *
     * @param projectId 从属项目ID
     * @param title     结点标题
     * @param info      结点介绍
     * @return 新建结点的ID
     */
    int create ( int projectId, String title, String info );

    /**
     * 更新一个结点
     *
     * @param workflowEntity 工作流结点实体
     */
    void update ( WorkflowEntity workflowEntity );

    /**
     * 删除一个结点
     *
     * @param workflowId 工作流结点实体
     */
    void delete ( int workflowId );

    /**
     * 标记一个结点为完成状态
     *
     * @param workflowId 结点ID
     */
    void setFinished ( int workflowId );

    /**
     * 标记一个结点为未完成状态
     *
     * @param workflowId 结点ID
     */
    void setUnfinished ( int workflowId );

    /**
     * 标记一个结点为进行中状态
     *
     * @param workflowId 结点ID
     */
    void setProcessing ( int workflowId );

    /**
     * 根据ID获取一个结点实体
     *
     * @param workflowId 结点ID
     * @return 结点实体
     */
    WorkflowEntity getById ( int workflowId );

    /**
     * 获取一个项目的所有节点
     *
     * @param projectId 项目ID
     * @return 所有节点实体列表
     */
    List<WorkflowEntity> getByProjectId ( int projectId );
}
