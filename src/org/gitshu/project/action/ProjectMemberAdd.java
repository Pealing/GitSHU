package org.gitshu.project.action;

import org.gitshu.project.service.ProjectMemberService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/29 23:32.
 * 向某个项目添加成员
 */
@Controller
public class ProjectMemberAdd extends ActionVariableSupport {
    private final ProjectMemberService projectMemberService;

    @Autowired
    public ProjectMemberAdd ( ProjectMemberService projectMemberService ) {
        this.projectMemberService = projectMemberService;
    }

    public String execute () {
        throw new UnsupportedOperationException();
    }
}
