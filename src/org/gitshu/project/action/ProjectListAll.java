package org.gitshu.project.action;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.project.service.ProjectService;
import org.gitshu.utils.action.ActionVariableSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lodour on 17/5/29 23:32.
 * 所有项目列表
 */
@Controller
public class ProjectListAll extends ActionVariableSupport {
    private final ProjectService projectService;
    // Action所使用的数据实体
    private List<ProjectEntity> projectEntityList = new ArrayList<>();

    @Autowired
    public ProjectListAll ( ProjectService projectService ) {
        this.projectService = projectService;
    }

    public String execute () {
        throw new UnsupportedOperationException();
    }

    public List<ProjectEntity> getProjectEntityList () {
        return projectEntityList;
    }

    public void setProjectEntityList ( List<ProjectEntity> projectEntityList ) {
        this.projectEntityList = projectEntityList;
    }
}
