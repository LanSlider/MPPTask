package com.spring.itdocmanager.dao;

import com.spring.itdocmanager.model.Tester;

import java.util.List;

public interface TesterDao {
    public void addTester(Tester tester);

    public void updateTester(Tester tester);

    public void delTester(int id);

    public Tester getTesterById(int id);

    public List<Tester> listTester();
}
