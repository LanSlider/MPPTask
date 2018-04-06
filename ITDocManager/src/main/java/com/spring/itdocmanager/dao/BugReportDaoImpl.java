package com.spring.itdocmanager.dao;

import com.spring.itdocmanager.model.BugReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BugReportDaoImpl implements BugReportDao{
    private static final Logger logger = LoggerFactory.getLogger(BugReportDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addBugReport(BugReport bugReport) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bugReport);
        logger.info("Bug report successfully saved. Bug report details: " + bugReport);
    }

    @Override
    public void updateBugReport(BugReport bugReport) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(bugReport);
        logger.info("Bug report successfully update. Bug report details: " + bugReport);
    }

    @Override
    public void delBugReport(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        BugReport bugReport = (BugReport) session.load(BugReport.class, new Integer(id));

        if(bugReport!=null){
            session.delete(bugReport);
        }
        logger.info("Bug report successfully removed. Bug report details: " + bugReport);
    }

    @Override
    public BugReport getBugReportById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        BugReport bugReport = (BugReport) session.load(BugReport.class, new Integer(id));
        logger.info("Bug report successfully loaded. Bug report details: " + bugReport);

        return bugReport;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BugReport> listBugReport() {
        Session session = this.sessionFactory.getCurrentSession();
        List<BugReport> bugReportList = session.createQuery("from BugReport").list();

        for(BugReport bugReport: bugReportList){
            logger.info("Bug report list: " + bugReport);
        }

        return bugReportList;
    }
}
