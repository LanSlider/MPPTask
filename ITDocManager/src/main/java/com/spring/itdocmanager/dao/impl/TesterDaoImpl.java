package com.spring.itdocmanager.dao.impl;

import com.spring.itdocmanager.dao.TesterDao;
import com.spring.itdocmanager.model.BugReport;
import com.spring.itdocmanager.model.Tester;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TesterDaoImpl implements TesterDao {
    private static final Logger logger = LoggerFactory.getLogger(TesterDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addTester(Tester tester) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tester);
        logger.info("Tester successfully saved. Tester details: " + tester);

    }

    @Override
    public void updateTester(Tester tester) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(tester);
        logger.info("Tester successfully update. Tester details: " + tester);
    }

    @Override
    public void delTester(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tester tester = (Tester) session.load(Tester.class, new Integer(id));

        if(tester!=null){
            session.delete(tester);
        }
        logger.info("Tester successfully removed. Tester details: " + tester);
    }

    @Override
    public Tester getTesterById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Tester tester = (Tester) session.load(Tester.class, new Integer(id));
        logger.info("Tester successfully loaded. Tester details: " + tester);

        return tester;
    }

    @Override
    public Boolean isGetBugReportById(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM BugReport where idBugReport = '" + id + "'");
        List<BugReport> bugReportList = query.list();
        if (bugReportList.isEmpty())
            return false;
        else
            return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tester> listTester() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Tester> testerList = session.createQuery("from Tester").list();

        for(Tester tester: testerList){
            logger.info("Tester list: " + tester);
        }

        return testerList;
    }
}
