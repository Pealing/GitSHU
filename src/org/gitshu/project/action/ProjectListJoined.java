package org.gitshu.project.action;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.project.service.ProjectMemberService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Lodour on 17/5/29 23:32.
 * 我参与的项目列表
 */
@Controller
public class ProjectListJoined extends ActionVariableSupport {
    private final ProjectMemberService projectMemberService;

    @Autowired
    public ProjectListJoined ( ProjectMemberService projectMemberService ) {
        this.projectMemberService = projectMemberService;
    }

    public String execute () {
        String username = (String) httpSession.get("username");
        System.out.println(username);
        List<ProjectEntity> projectEntityList = projectMemberService.getJoinedProjects(username);
        httpServletRequest.setAttribute("projects", projectEntityList);
        System.out.println("123:" + projectEntityList);
        return SUCCESS;
    }
}
