package com.yz.zhxy.entity;

import java.io.Serializable;
import java.util.Date;

public class TeacherInfo implements Serializable {
    private Long userId;

    private Long id;

    private Long schoolId;

    private Byte isFreeNormalStudent;

    private Byte isSpecialPostTeacher;

    private String specialTeacher;

    private Byte isKeyTeacher;

    private String keyTeacher;

    private String politicalStatus;

    private String duty;

    private String jobTitle;

    private String jobTitleLevel;

    private Date jobTitleDate;

    private String teflCode;

    private String eduLevel;

    private String eduLevelSchool;

    private String eduLevelMajor;

    private String eduDegree;

    private String eduDegreeSchool;

    private String eduDegreeMajor;

    private String initialEduLevel;

    private String initialEduLevelSchool;

    private String initialEduLevelMajor;

    private Date createTs;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Byte getIsFreeNormalStudent() {
        return isFreeNormalStudent;
    }

    public void setIsFreeNormalStudent(Byte isFreeNormalStudent) {
        this.isFreeNormalStudent = isFreeNormalStudent;
    }

    public Byte getIsSpecialPostTeacher() {
        return isSpecialPostTeacher;
    }

    public void setIsSpecialPostTeacher(Byte isSpecialPostTeacher) {
        this.isSpecialPostTeacher = isSpecialPostTeacher;
    }

    public String getSpecialTeacher() {
        return specialTeacher;
    }

    public void setSpecialTeacher(String specialTeacher) {
        this.specialTeacher = specialTeacher == null ? null : specialTeacher.trim();
    }

    public Byte getIsKeyTeacher() {
        return isKeyTeacher;
    }

    public void setIsKeyTeacher(Byte isKeyTeacher) {
        this.isKeyTeacher = isKeyTeacher;
    }

    public String getKeyTeacher() {
        return keyTeacher;
    }

    public void setKeyTeacher(String keyTeacher) {
        this.keyTeacher = keyTeacher == null ? null : keyTeacher.trim();
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus == null ? null : politicalStatus.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getJobTitleLevel() {
        return jobTitleLevel;
    }

    public void setJobTitleLevel(String jobTitleLevel) {
        this.jobTitleLevel = jobTitleLevel == null ? null : jobTitleLevel.trim();
    }

    public Date getJobTitleDate() {
        return jobTitleDate;
    }

    public void setJobTitleDate(Date jobTitleDate) {
        this.jobTitleDate = jobTitleDate;
    }

    public String getTeflCode() {
        return teflCode;
    }

    public void setTeflCode(String teflCode) {
        this.teflCode = teflCode == null ? null : teflCode.trim();
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel == null ? null : eduLevel.trim();
    }

    public String getEduLevelSchool() {
        return eduLevelSchool;
    }

    public void setEduLevelSchool(String eduLevelSchool) {
        this.eduLevelSchool = eduLevelSchool == null ? null : eduLevelSchool.trim();
    }

    public String getEduLevelMajor() {
        return eduLevelMajor;
    }

    public void setEduLevelMajor(String eduLevelMajor) {
        this.eduLevelMajor = eduLevelMajor == null ? null : eduLevelMajor.trim();
    }

    public String getEduDegree() {
        return eduDegree;
    }

    public void setEduDegree(String eduDegree) {
        this.eduDegree = eduDegree == null ? null : eduDegree.trim();
    }

    public String getEduDegreeSchool() {
        return eduDegreeSchool;
    }

    public void setEduDegreeSchool(String eduDegreeSchool) {
        this.eduDegreeSchool = eduDegreeSchool == null ? null : eduDegreeSchool.trim();
    }

    public String getEduDegreeMajor() {
        return eduDegreeMajor;
    }

    public void setEduDegreeMajor(String eduDegreeMajor) {
        this.eduDegreeMajor = eduDegreeMajor == null ? null : eduDegreeMajor.trim();
    }

    public String getInitialEduLevel() {
        return initialEduLevel;
    }

    public void setInitialEduLevel(String initialEduLevel) {
        this.initialEduLevel = initialEduLevel == null ? null : initialEduLevel.trim();
    }

    public String getInitialEduLevelSchool() {
        return initialEduLevelSchool;
    }

    public void setInitialEduLevelSchool(String initialEduLevelSchool) {
        this.initialEduLevelSchool = initialEduLevelSchool == null ? null : initialEduLevelSchool.trim();
    }

    public String getInitialEduLevelMajor() {
        return initialEduLevelMajor;
    }

    public void setInitialEduLevelMajor(String initialEduLevelMajor) {
        this.initialEduLevelMajor = initialEduLevelMajor == null ? null : initialEduLevelMajor.trim();
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", id=").append(id);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", isFreeNormalStudent=").append(isFreeNormalStudent);
        sb.append(", isSpecialPostTeacher=").append(isSpecialPostTeacher);
        sb.append(", specialTeacher=").append(specialTeacher);
        sb.append(", isKeyTeacher=").append(isKeyTeacher);
        sb.append(", keyTeacher=").append(keyTeacher);
        sb.append(", politicalStatus=").append(politicalStatus);
        sb.append(", duty=").append(duty);
        sb.append(", jobTitle=").append(jobTitle);
        sb.append(", jobTitleLevel=").append(jobTitleLevel);
        sb.append(", jobTitleDate=").append(jobTitleDate);
        sb.append(", teflCode=").append(teflCode);
        sb.append(", eduLevel=").append(eduLevel);
        sb.append(", eduLevelSchool=").append(eduLevelSchool);
        sb.append(", eduLevelMajor=").append(eduLevelMajor);
        sb.append(", eduDegree=").append(eduDegree);
        sb.append(", eduDegreeSchool=").append(eduDegreeSchool);
        sb.append(", eduDegreeMajor=").append(eduDegreeMajor);
        sb.append(", initialEduLevel=").append(initialEduLevel);
        sb.append(", initialEduLevelSchool=").append(initialEduLevelSchool);
        sb.append(", initialEduLevelMajor=").append(initialEduLevelMajor);
        sb.append(", createTs=").append(createTs);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}