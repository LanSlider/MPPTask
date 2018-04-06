package com.spring.itdocmanager.service;

import com.spring.itdocmanager.dao.BugReportDao;
import com.spring.itdocmanager.model.BugReport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BugReportServiceImpl implements BugReportService {
    private BugReportDao bugReportDao;

    public void setBugReportDao(BugReportDao bugReportDao) {
        this.bugReportDao = bugReportDao;
    }

    @Override
    @Transactional
    public void addBugReport(BugReport bugReport) { this.bugReportDao.addBugReport(bugReport);}

    @Override
    @Transactional
    public void updateBugReport(BugReport bugReport) { this.bugReportDao.updateBugReport(bugReport); }

    @Override
    @Transactional
    public void delBugReport(int id) { this.bugReportDao.delBugReport(id); }

    @Override
    @Transactional
    public BugReport getBugReportById(int id) { return this.bugReportDao.getBugReportById(id); }

    @Override
    @Transactional
    public List<BugReport> listBugReport() { return this.bugReportDao.listBugReport();}
}
