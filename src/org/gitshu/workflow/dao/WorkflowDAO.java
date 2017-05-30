package org.gitshu.workflow.dao;

import org.gitshu.entity.WorkflowEntity;

import java.util.List;

/**
 * Created by Lodour on 17/5/30 00:38.
 * 工作流DAO
 */
public interface WorkflowDAO {

    /**
     * 创建一个新结点
     *
     * @param workflowEntity 结点实体
     * @return 新建结点的ID
     */
    int create ( WorkflowEntity workflowEntity );

    /**
     * 更新一个结点
     *
     * @param workflowEntity 结点实体
     */
    void
    update ( WorkflowEntity workflowEntity );


    /**
     * 删除一个结点
     *
     * @param workflowId 结点编号
     */
    void delete ( int workflowId );

    /**
     * 设置结点窗台
     *
     * @param workflowId 结点ID
     * @param status     状态
     */
    void setStatus ( int workflowId, int status );

    /**
     * 根据ID获取结点实体
     *
     * @param workflowId 结点ID
     * @return 结点实体
     */
    WorkflowEntity getById ( int workflowId );

    /**
     * 根据项目ID获取所属结点列表
     *
     * @param projectId 项目ID
     * @return 结点列表
     */
    List getByProjectId ( int projectId );
}
