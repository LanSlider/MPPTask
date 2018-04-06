package com.spring.itdocmanager.service;

import com.spring.itdocmanager.dao.TesterDao;
import com.spring.itdocmanager.model.Tester;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("testerService")
public class TesterServiceImpl implements TesterService {
    private TesterDao testerDao;

    public void setTesterDao(TesterDao testerDao) {
        this.testerDao = testerDao;
    }

    @Override
    @Transactional
    public void addTester(Tester tester) {
        this.testerDao.addTester(tester);
    }

    @Override
    @Transactional
    public void updateTester(Tester tester) {
        this.testerDao.updateTester(tester);
    }

    @Override
    @Transactional
    public void delTester(int id) {
        this.testerDao.delTester(id);
    }

    @Override
    @Transactional
    public Tester getTesterById(int id) {
        return this.testerDao.getTesterById(id);
    }

    @Override
    @Transactional
    public List<Tester> listTester() {
        return this.testerDao.listTester();
    }
}
