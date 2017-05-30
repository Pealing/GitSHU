package org.gitshu.workflow.action;

import org.gitshu.entity.WorkflowEntity;
import org.gitshu.project.service.ProjectService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.gitshu.workflow.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Lodour on 17/5/30 00:43.
 * 查看项目的工作流
 */
@Controller
public class WorkflowView extends ActionVariableSupport {
    private final WorkflowService workflowService;
    private final ProjectService projectService;
    private int projectId;

    @Autowired
    public WorkflowView ( WorkflowService workflowService, ProjectService projectService ) {
        this.workflowService = workflowService;
        this.projectService = projectService;
    }

    public String execute () {
        List<WorkflowEntity> workflowEntityList = workflowService.getByProjectId(projectId);
        httpServletRequest.setAttribute("nodes", workflowEntityList);
        httpServletRequest.setAttribute("projectEntity", projectService.getById(projectId));
        return SUCCESS;
    }

    public int getProjectId () {
        return projectId;
    }

    public void setProjectId ( int projectId ) {
        this.projectId = projectId;
    }
}
