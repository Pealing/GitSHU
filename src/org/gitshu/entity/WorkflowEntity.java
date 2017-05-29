package org.gitshu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Lodour on 17/5/29 20:26.
 */
@Entity
@Table(name = "workflow", schema = "test", catalog = "")
public class WorkflowEntity {
    private int id;
    private Timestamp createTime;
    private String title;
    private String info;
    private int status;
    private ProjectEntity projectByProject;

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

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "info", nullable = true, length = -1)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkflowEntity that = (WorkflowEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return info != null ? info.equals(that.info) : that.info == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + status;
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
}
