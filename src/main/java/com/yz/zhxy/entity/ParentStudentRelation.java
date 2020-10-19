package com.yz.zhxy.entity;

import java.io.Serializable;
import java.util.Date;

public class ParentStudentRelation implements Serializable {
    private String id;

    private String parentUser;

    private String studentUser;

    private Byte type;

    private Date createTs;

    private Date updateTs;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentUser() {
        return parentUser;
    }

    public void setParentUser(String parentUser) {
        this.parentUser = parentUser == null ? null : parentUser.trim();
    }

    public String getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(String studentUser) {
        this.studentUser = studentUser == null ? null : studentUser.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentUser=").append(parentUser);
        sb.append(", studentUser=").append(studentUser);
        sb.append(", type=").append(type);
        sb.append(", createTs=").append(createTs);
        sb.append(", updateTs=").append(updateTs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}