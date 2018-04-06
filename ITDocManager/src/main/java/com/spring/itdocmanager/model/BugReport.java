package com.spring.itdocmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "bugreport", schema = "db")
public class BugReport {
    @Id
    @Column(name = "idBugReport")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NameProject")
    private String nameProject;

    @Column(name = "BugDescription")
    private String bugDescription;

    @Column(name = "Priority")
    private String priority;

    @Column(name = "ActualResult")
    private String actualResult;

    @Column(name = "ExpectedResult")
    private String expectedResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getBugDescription() {
        return bugDescription;
    }

    public void setBugDescription(String bugDescription) {
        this.bugDescription = bugDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Override
    public String toString() {
        return "BugReport{" +
                "id=" + id +
                ", nameProject='" + nameProject + '\'' +
                ", bugDescription='" + bugDescription + '\'' +
                ", priority='" + priority + '\'' +
                ", actualResult='" + actualResult + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}

