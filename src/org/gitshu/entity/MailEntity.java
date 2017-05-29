package org.gitshu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Lodour on 17/5/29 20:26.
 */
@Entity
@Table(name = "mail", schema = "test", catalog = "")
public class MailEntity {
    private int id;
    private Timestamp createTime;
    private byte isRead;
    private String content;
    private int type;
    private UserEntity userByAuthor;
    private UserEntity userByReceiver;

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
    @Column(name = "isRead", nullable = false)
    public byte getIsRead() {
        return isRead;
    }

    public void setIsRead(byte isRead) {
        this.isRead = isRead;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailEntity that = (MailEntity) o;

        if (id != that.id) return false;
        if (isRead != that.isRead) return false;
        if (type != that.type) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (int) isRead;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByAuthor() {
        return userByAuthor;
    }

    public void setUserByAuthor(UserEntity userByAuthor) {
        this.userByAuthor = userByAuthor;
    }

    @ManyToOne
    @JoinColumn(name = "receiver", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByReceiver() {
        return userByReceiver;
    }

    public void setUserByReceiver(UserEntity userByReceiver) {
        this.userByReceiver = userByReceiver;
    }
}
