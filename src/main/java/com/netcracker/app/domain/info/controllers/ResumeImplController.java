/*
package com.netcracker.app.domain.info.controllers;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.info.services.resumes.ResumeImplService;
import com.netcracker.app.domain.info.services.vacancies.VacancyImplService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.Map;

@Controller
public class ResumeImplController {
    private VacancyImplService service;
    private ResumeImplService resumeImplService;

    public ResumeImplController(VacancyImplService service, ResumeImplService resumeImplService) {
        this.service = service;
        this.resumeImplService = resumeImplService;
    }

    @Transactional
    @GetMapping("/resume/{id}")
    public String resume(@PathVariable("id") Integer id, Map<String, Object> model) {
        model.put("vacancy", service.getById(id));
        return "resume";
    }

    @Transactional
    @PostMapping("addResume")
    public String addResume(@ModelAttribute("vacancy") VacancyImpl vacancy, @ModelAttribute("resume") ResumeImpl resume, Map<String, Object> model) throws Exception {
        resume.setVacancy(vacancy);
        resumeImplService.add(resume);
        model.put("yourResume", resume);
        return "yourResume";
    }
}
*/
