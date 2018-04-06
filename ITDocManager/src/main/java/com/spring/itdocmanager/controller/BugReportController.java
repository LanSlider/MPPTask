package com.spring.itdocmanager.controller;

import com.spring.itdocmanager.model.BugReport;
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
public class BugReportController {

    @Resource(name = "bugReportService")
    private BugReportService bugReportService;

    @Autowired(required = true)
    @Qualifier(value = "bugReportService")
    public void setTesterService(BugReportService bugReportService) {
        this.bugReportService = bugReportService;
    }

    @RequestMapping(value = "bugreports", method = RequestMethod.GET)
    public String listBugReport(Model model) {
        model.addAttribute("bugReport", new BugReport());
        model.addAttribute("listBugReports", this.bugReportService.listBugReport());

        return "bugreports";
    }

    @RequestMapping(value = "/bugreports/add", method = RequestMethod.POST)
    public String addBugReport(@ModelAttribute("bugReport") BugReport bugReport) {
        if((bugReport.getPriority().equals("Middle") || bugReport.getPriority().equals("High") || bugReport.getPriority().equals("Low")) && (!isNumber(bugReport.getActualResult())) && (!isNumber(bugReport.getBugDescription())) && (!isNumber(bugReport.getExpectedResult())) && (!isNumber(bugReport.getNameProject()))) {
            if (bugReport.getId() == 0) {
                this.bugReportService.addBugReport(bugReport);
                Boolean r = true;
            } else {
                Boolean r = false;
                this.bugReportService.updateBugReport(bugReport);
            }
        }

        return "redirect: /bugreports";
    }

    @RequestMapping("bugreport/remove/{id}")
    public String removeBugReport(@PathVariable("id") int id) {
        this.bugReportService.delBugReport(id);

        return "redirect: /bugreports";
    }

    @RequestMapping("bugreport/edit/{id}")
    public String editBugReport(@PathVariable("id") int id, Model model) {
        model.addAttribute("bugReport", this.bugReportService.getBugReportById(id));
        model.addAttribute("listBugReports", this.bugReportService.listBugReport());

        return "bugreports";
    }

    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
