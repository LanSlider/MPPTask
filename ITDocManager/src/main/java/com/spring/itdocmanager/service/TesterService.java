package com.spring.itdocmanager.service;

import com.spring.itdocmanager.model.Tester;

import java.util.List;

public interface TesterService {
    public void addTester(Tester tester);

    public void updateTester(Tester tester);

    public void delTester(int id);

    public Tester getTesterById(int id);

    public Boolean isGetBugReportById(int id);

    public List<Tester> listTester();
}
