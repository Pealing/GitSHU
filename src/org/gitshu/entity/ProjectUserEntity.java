package org.gitshu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Lodour on 17/5/29 20:26.
 */
@Entity
@Table(name = "project_user", schema = "test", catalog = "")
public class ProjectUserEntity {
    private int id;
    private Timestamp createTime;
    private ProjectEntity projectByProject;
    private UserEntity userByUser;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectUserEntity that = (ProjectUserEntity) o;

        if (id != that.id) return false;
        return createTime != null ? createTime.equals(that.createTime) : that.createTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "project", referencedColumnName = "id", nullable = false)
    public ProjectEntity getProjectByProject() {
        return projectByProject;
    }

    public void setProjectByProject(ProjectEntity projectByProject) {
        this.projectByProject = projectByProject;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUser() {
        return userByUser;
    }

    public void setUserByUser(UserEntity userByUser) {
        this.userByUser = userByUser;
    }
}
