package com.spring.itdocmanager.controller;

import com.spring.itdocmanager.model.BugReport;
import com.spring.itdocmanager.model.Tester;
import com.spring.itdocmanager.service.BugReportService;
import com.spring.itdocmanager.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
public class TesterController {
    private BugReportService bugReportService;

    @Resource(name = "testerService")
    private TesterService testerService;

    @Autowired(required = true)
    @Qualifier(value = "testerService")
    public void setTesterService(TesterService testerService) {
        this.testerService = testerService;
    }

    @RequestMapping(value = "testers", method = RequestMethod.GET)
    public String listTester(Model model) {
        model.addAttribute("tester", new Tester());
        model.addAttribute("listTesters", this.testerService.listTester());

        return "testers";
    }

    @RequestMapping(value = "/testers/add", method = RequestMethod.POST)
    public String addTester(@ModelAttribute("tester") Tester tester) {
        if((!isNumber(tester.getName()) && (!isNumber(tester.getCompanyName())) && (tester.getPhone()) < 9999999) && (tester.getPhone() > 1000000) && (this.testerService.isGetBugReportById(tester.getIdBugReport())) ) {
            if (tester.getId() == 0) {
                this.testerService.addTester(tester);
            } else {
                this.testerService.updateTester(tester);
            }
        }
        return "redirect: /testers";
    }

    @RequestMapping("/remove/{id}")
    public String removeTester(@PathVariable("id") int id) {
        this.testerService.delTester(id);

        return "redirect: /testers";
    }

    @RequestMapping("edit/{id}")
    public String editTester(@PathVariable("id") int id, Model model) {
        model.addAttribute("tester", this.testerService.getTesterById(id));
        model.addAttribute("listTester", this.testerService.listTester());

        return "testers";
    }

    @RequestMapping("testerdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("tester", this.testerService.getTesterById(id));

        return "testerdata";
    }

    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
