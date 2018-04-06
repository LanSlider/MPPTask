package com.spring.itdocmanager.dao.impl;

import com.spring.itdocmanager.dao.TesterDao;
import com.spring.itdocmanager.model.Tester;
import com.spring.itdocmanager.service.impl.TesterServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesterDaoImplTest {

    TesterDao testerDao;

    @Before
    public void setUp() throws Exception {
        testerDao = new TesterDaoImpl();
    }

    @Test
    public void addTester() throws Exception {
        Tester tester = new Tester();
        tester.setId(1);
        testerDao.addTester(tester);
        assertEquals(testerDao.getTesterById(1), tester);
    }

    @Test
    public void updateTester() throws Exception {
        Tester tester = new Tester();
        tester.setId(1);
        tester.setCompanyName("Niks");
        testerDao.addTester(tester);
        tester.setCompanyName("Google");
        testerDao.updateTester(tester);
        assertEquals(testerDao.getTesterById(1).getCompanyName(), tester.getCompanyName());
    }

    @Test
    public void delTester() throws Exception {
        Tester tester = new Tester();
        tester.setId(1);
        testerDao.addTester(tester);
        testerDao.delTester(tester.getId());
        assertNotEquals(testerDao.getTesterById(1), tester.getId());
    }

    @Test
    public void getTesterById() throws Exception {
        Tester tester = new Tester();
        tester.setId(1);
        testerDao.addTester(tester);
        assertEquals(testerDao.getTesterById(1), tester);
    }

    @Test
    public void isGetBugReportById() throws Exception {
        Tester tester = new Tester();
        tester.setId(1);
        testerDao.addTester(tester);
        assertFalse(testerDao.isGetBugReportById(tester.getId()));
    }

}