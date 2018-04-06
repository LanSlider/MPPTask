package com.spring.itdocmanager.dao.impl;

import com.spring.itdocmanager.dao.BugReportDao;
import com.spring.itdocmanager.model.BugReport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BugReportDaoImplTest {

    BugReportDao bugReportDao;

    @Before
    public void setUp() throws Exception {
        bugReportDao = new BugReportDaoImpl();
    }

    @Test
    public void addBugReport() throws Exception {
        BugReport report = new BugReport();
        report.setId(1);
        bugReportDao.addBugReport(report);
        assertEquals(bugReportDao.getBugReportById(1), report);
    }

    @Test
    public void updateBugReport() throws Exception {
        BugReport report = new BugReport();
        report.setId(1);
        report.setNameProject("Pro1");
        bugReportDao.addBugReport(report);
        report.setNameProject("Pro2");
        bugReportDao.updateBugReport(report);
        assertEquals(bugReportDao.getBugReportById(1).getNameProject(), report.getNameProject());
    }

    @Test
    public void delBugReport() throws Exception {
        BugReport report = new BugReport();
        report.setId(1);
        bugReportDao.addBugReport(report);
        bugReportDao.delBugReport(report.getId());
        assertNotEquals(bugReportDao.getBugReportById(1), report);
    }

    @Test
    public void getBugReportById() throws Exception {
        BugReport report = new BugReport();
        report.setId(1);
        bugReportDao.addBugReport(report);
        assertEquals(bugReportDao.getBugReportById(1), report);
    }

}