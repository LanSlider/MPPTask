package com.spring.itdocmanager.service;

import com.spring.itdocmanager.model.BugReport;

import java.util.List;

public interface BugReportService {
    public void addBugReport(BugReport bugReport);

    public void updateBugReport(BugReport bugReport);

    public void delBugReport(int id);

    public BugReport getBugReportById(int id);

    public List<BugReport> listBugReport();
}
