package org.gitshu.project.dao;

import org.gitshu.entity.ProjectEntity;
import org.gitshu.entity.UserEntity;

/**
 * Created by Lodour on 17/5/29 22:05.
 * 项目-用户DAO
 */
public interface ProjectMemberDAO {

    /**
     * 添加项目成员
     *
     * @param projectEntity 项目实体
     * @param userEntity    用户实体
     */
    void add ( ProjectEntity projectEntity, UserEntity userEntity );

}
