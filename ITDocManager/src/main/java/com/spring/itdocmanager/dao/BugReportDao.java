package com.spring.itdocmanager.dao;

import com.spring.itdocmanager.model.BugReport;

import java.util.List;

public interface BugReportDao {
    public void addBugReport(BugReport bugReport);

    public void updateBugReport(BugReport bugReport);

    public void delBugReport(int id);

    public BugReport getBugReportById(int id);

    public List<BugReport> listBugReport();
}
