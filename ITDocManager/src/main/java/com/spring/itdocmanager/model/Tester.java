package com.spring.itdocmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "tester", schema = "db")
public class Tester {
    @Id
    @Column(name = "idTester")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "Phone")
    private int phone;

    @Column(name = "idBugReport")
    private int idBugReport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getIdBugReport() {
        return idBugReport;
    }

    public void setIdBugReport(int idBugReport) {
        this.idBugReport = idBugReport;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company name='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                ", idReportBug=" + idBugReport +
                '}';
    }
}
