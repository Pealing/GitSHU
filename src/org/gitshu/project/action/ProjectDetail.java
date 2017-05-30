package org.gitshu.project.action;

import org.gitshu.project.service.ProjectService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/29 23:32.
 * 项目详细信息
 */
@Controller
public class ProjectDetail extends ActionVariableSupport {
    private final ProjectService projectService;

    @Autowired
    public ProjectDetail ( ProjectService projectService ) {
        this.projectService = projectService;
    }

    public String execute () {
        throw new UnsupportedOperationException();
    }
}
