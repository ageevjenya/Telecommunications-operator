package com.netcracker.app.domain.info.controllers.vacancyAndResume;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.info.services.resumes.ResumeImplService;
import com.netcracker.app.domain.info.services.vacancies.VacancyImplService;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class VacancyResumeImplController {
    private final VacancyImplService service;
    private final ResumeImplService resumeImplService;
    private final UserRepo userRepo;

    public VacancyResumeImplController(VacancyImplService service, ResumeImplService resumeImplService, UserRepo userRepo) {
        this.service = service;
        this.resumeImplService = resumeImplService;
        this.userRepo = userRepo;
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
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        model.put("resumes", resumeImplService.getAll().stream().filter(e -> e.getUser().getId() == user.getId()
                && e.getVacancy().getId() == id).collect(Collectors.toList()));
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
    @PostMapping("/resume/{id}")
    public String addResume(@PathVariable("id") Integer id,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String birthday,
                            @RequestParam String phone,
                            @RequestParam String email,
                            @RequestParam String text,
                            Map<String, Object> model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        VacancyImpl vacancy = service.getById(id);
        ResumeImpl resume = new ResumeImpl(firstName, lastName, birthday, phone, email, text, vacancy);
        resume.setUser(user);
        resumeImplService.add(resume);
        model.put("yourResume", resume);
        return "yourResume";
    }

    @Transactional
    @GetMapping("resume/{id}/yourResume")
    public String yourResume(@PathVariable("id") ResumeImpl resume, Map<String, Object> model) {
        model.put("yourResume", resume);
        return "yourResume";
    }
}
