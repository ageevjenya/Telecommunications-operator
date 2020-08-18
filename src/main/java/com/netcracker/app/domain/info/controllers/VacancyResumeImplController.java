package com.netcracker.app.domain.info.controllers;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.info.services.resumes.ResumeImplService;
import com.netcracker.app.domain.info.services.vacancies.VacancyImplService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.Map;

@Controller
public class VacancyResumeImplController {
    private VacancyImplService service;
    private ResumeImplService resumeImplService;

    public VacancyResumeImplController(VacancyImplService service, ResumeImplService resumeImplService) {
        this.service = service;
        this.resumeImplService = resumeImplService;
    }

    @Transactional
    @GetMapping("work")
    public String work(Model model) {
        model.addAttribute("vacancies", service.getAll());
        return "work";
    }

    @Transactional
    @GetMapping("/vacancy/{id}")
    public String vacancy(@PathVariable("id") Integer id, Map<String, Object> model) {
        model.put("vacancy", service.getById(id));
        return "vacancy";
    }

    @Transactional
    @GetMapping("/resume/{id}")
    public String resume(@PathVariable("id") Integer id, Map<String, Object> model) {
        model.put("vacancy", service.getById(id));
        return "resume";
    }

    @Transactional
    @PostMapping("addResume") //405 error (method is known by server but was turned off)
    public String addResume(@ModelAttribute("vacancy") VacancyImpl vacancy, @ModelAttribute("resume") ResumeImpl resume, Map<String, Object> model) throws Exception {
        resume.setVacancy(vacancy);
        resumeImplService.add(resume);
        model.put("yourResume", resume);
        return "yourResume";
    }

}
