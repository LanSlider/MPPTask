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
    }

    @Test
    public void delBugReport() throws Exception {
    }

    @Test
    public void getBugReportById() throws Exception {
    }

    @Test
    public void listBugReport() throws Exception {
    }

}