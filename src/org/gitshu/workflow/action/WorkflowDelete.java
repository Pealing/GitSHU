package org.gitshu.workflow.action;

import org.gitshu.utils.action.ActionVariableSupport;
import org.gitshu.workflow.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/30 00:43.
 * 删除指定的结点
 */
@Controller
public class WorkflowDelete extends ActionVariableSupport {
    private final WorkflowService workflowService;
    private int projectId;

    @Autowired
    public WorkflowDelete ( WorkflowService workflowService ) {
        this.workflowService = workflowService;
    }

    public String execute () {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        projectId = workflowService.getById(id).getProjectByProject().getId();
        workflowService.delete(id);
        return SUCCESS;
    }

    public int getProjectId () {
        return projectId;
    }

    public void setProjectId ( int projectId ) {
        this.projectId = projectId;
    }
}
