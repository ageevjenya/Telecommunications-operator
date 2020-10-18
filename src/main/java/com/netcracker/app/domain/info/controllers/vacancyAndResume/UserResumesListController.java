package com.netcracker.app.domain.info.controllers.vacancyAndResume;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.info.repositories.resumes.ResumeImplRepository;
import com.netcracker.app.domain.info.repositories.vacancies.VacancyImplRepository;
import com.netcracker.app.domain.users.entities.Role;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserResumesListController {
    private final UserRepo userRepo;
    private final ResumeImplRepository resumeImplRepository;
    private final VacancyImplRepository vacancyImplRepository;

    public UserResumesListController(UserRepo userRepo, ResumeImplRepository resumeImplRepository, VacancyImplRepository vacancyImplRepository) {
        this.userRepo = userRepo;
        this.resumeImplRepository = resumeImplRepository;
        this.vacancyImplRepository = vacancyImplRepository;
    }

    @GetMapping("/userResumesList")
    public String userResumes(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null || user.getRoles().stream().noneMatch(e -> e.getAuthority().equals("ADMIN") || e.getAuthority().equals("MANAGER"))) {
            return "/";
        }
        List<ResumeImpl> resumes = resumeImplRepository.findAll().stream()
                .filter(e -> e.getAccepted() == null).collect(Collectors.toList());
        boolean exists = resumeImplRepository.findAll().stream().anyMatch(e -> e.getAccepted() == null);
        String exist = "";
        if (exists) {
            exist = "да";
        } else {
            exist = "нет";
        }

        model.addAttribute("exists", exist);
        model.addAttribute("resumes", resumes);
        return "userResumesList";
    }
    @PostMapping("/yes")
    public String yes(@RequestParam("userId") long userId,
                      @RequestParam("resumeId") int resumeId,
                      @RequestParam("vacancyId") int vacancyId) {
        User user = userRepo.getOne(userId);
        String roleName = vacancyImplRepository.getById(vacancyId).getName();
        if (roleName.equals("Администратор")) {
            user.setRole(Role.ADMIN);
        } else if (roleName.equals("Оператор")) {
            user.setRole(Role.SUPPORT);
        } else if (roleName.equals("Менеджер")) {
            user.setRole(Role.MANAGER);
        }
        userRepo.saveAndFlush(user);
        ResumeImpl resume = resumeImplRepository.getById(resumeId);
        resume.setAccepted("принято");
        resumeImplRepository.saveAndFlush(resume);
        return "redirect:/userResumesList";
    }

    @PostMapping("/no")
    public String no(@RequestParam("resumeId") ResumeImpl resume) {
        resume.setAccepted("отклонено");
        resumeImplRepository.saveAndFlush(resume);
        return "redirect:/userResumesList";
    }
}
