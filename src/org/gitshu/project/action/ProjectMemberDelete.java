package org.gitshu.project.action;

import org.gitshu.project.service.ProjectMemberService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lodour on 17/5/29 23:32.
 * 从某个项目删除成员
 */
@Controller
public class ProjectMemberDelete extends ActionVariableSupport {
    private final ProjectMemberService projectMemberService;

    @Autowired
    public ProjectMemberDelete ( ProjectMemberService projectMemberService ) {
        this.projectMemberService = projectMemberService;
    }

    public String execute () {
        throw new UnsupportedOperationException();
    }
}
