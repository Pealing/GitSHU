package org.gitshu.workflow.action;

import org.gitshu.utils.action.ActionVariableSupport;
import org.gitshu.workflow.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by Lodour on 17/5/30 00:43.
 * 创建新结点
 */
@Controller
public class WorkflowCreate extends ActionVariableSupport {
    private final WorkflowService workflowService;
    private int projectId;

    @Autowired
    public WorkflowCreate ( WorkflowService workflowService ) {
        this.workflowService = workflowService;
    }

    public String execute () throws IOException {
        projectId = Integer.parseInt(httpServletRequest.getParameter("id"));
        String nodeNames = httpServletRequest.getParameter("nodeNames");
        String nodeInfo = httpServletRequest.getParameter("nodeInfo");
        int newNodeId = workflowService.create(projectId, nodeNames, nodeInfo);
        httpServletRequest.setAttribute("newNodeId", newNodeId);
        return SUCCESS;
    }

    public int getProjectId () {
        return projectId;
    }

    public void setProjectId ( int projectId ) {
        this.projectId = projectId;
    }
}
