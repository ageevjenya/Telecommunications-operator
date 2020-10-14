package com.netcracker.app.domain.personalArea;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.info.services.resumes.ResumeImplService;
import com.netcracker.app.domain.info.services.vacancies.VacancyImplService;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/personalArea")
public class personalAreaController {

    private final UserRepo userRepo;
    private final ResumeImplService resumeImplService;
    private final VacancyImplService vacancyImplService;

    public personalAreaController(UserRepo userRepo, ResumeImplService resumeImplService, VacancyImplService vacancyImplService) {
        this.userRepo = userRepo;
        this.resumeImplService = resumeImplService;
        this.vacancyImplService = vacancyImplService;
    }

    @GetMapping
    public String getpersonalArea(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "login";
        }

        if (user.getTariffMobile()!=null){
            StringBuilder usedTariffMobile = new StringBuilder();
            Double usedInternet = user.getTariffMobile().getGbInternet() - user.getUserUsedTariffMobile().getUsedInternet();
            Integer usedMinutes = user.getTariffMobile().getMinutes() - user.getUserUsedTariffMobile().getUsedMinutes();
            Integer usedSms = user.getTariffMobile().getSms() - user.getUserUsedTariffMobile().getUsedSms();

            usedTariffMobile.append(usedInternet);
            usedTariffMobile.append(" Гб, ");
            usedTariffMobile.append(usedMinutes);
            usedTariffMobile.append(" минут, ");
            usedTariffMobile.append(usedSms);
            usedTariffMobile.append(" смс");
            model.addAttribute("usedTariffMobile", usedTariffMobile);
        }
        model.addAttribute("user", user);
        List<ResumeImpl> resumes = resumeImplService.getAll().stream().filter(e -> e.getUser().getId() == user.getId()).collect(Collectors.toList());
        model.addAttribute("resumes", resumes);
        return "personalArea";
    }

    @PostMapping("/add")
    public String postpersonalArea(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user != null) {
            return "login";
        }

        if (user.getTariffMobile()!=null){
            StringBuilder usedTariffMobile = new StringBuilder();
            Double usedInternet = user.getTariffMobile().getGbInternet() - user.getUserUsedTariffMobile().getUsedInternet();
            Integer usedMinutes = user.getTariffMobile().getMinutes() - user.getUserUsedTariffMobile().getUsedMinutes();
            Integer usedSms = user.getTariffMobile().getSms() - user.getUserUsedTariffMobile().getUsedSms();

            usedTariffMobile.append(usedInternet);
            usedTariffMobile.append(", ");
            usedTariffMobile.append(usedMinutes);
            usedTariffMobile.append(", ");
            usedTariffMobile.append(usedSms);
            model.addAttribute("usedTariffMobile", usedTariffMobile);
        }
        if (user.getTariffHome()!=null) {
            StringBuilder usedTariffHome = new StringBuilder();
//            Double usedInternet = user.getTariffHome().getGbInternet();
//            usedTariffMobile.append(usedInternet);
            usedTariffHome.append(" Безлимитно");
            model.addAttribute("usedTariffHome", usedTariffHome);

        }
        model.addAttribute("user", user);
        return "personalArea";
    }

    @Transactional
    @PostMapping("/update")
    public String update(@RequestParam("id") int id,
                         @RequestParam(defaultValue = "defaultValue", required = false) String vacancyName,
                         @RequestParam(defaultValue = "defaultValue", required = false) String firstName,
                         @RequestParam(defaultValue = "defaultValue", required = false) String lastName,
                         @RequestParam(defaultValue = "defaultValue", required = false) String birthday,
                         @RequestParam(defaultValue = "defaultValue", required = false) String phone,
                         @RequestParam(defaultValue = "defaultValue", required = false) String email,
                         @RequestParam(defaultValue = "defaultValue", required = false) String text,
                         Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (!vacancyName.equals("defaultValue")) {
            VacancyImpl vacancy = vacancyImplService.getByName(vacancyName);
            if (vacancy != null) {
                resumeImplService.updateVacancyId(vacancy, id);
            }
        }
        if (!firstName.equals("defaultValue")) {
            resumeImplService.updateFirstName(firstName, id);
        }
        if (!lastName.equals("defaultValue")) {
            resumeImplService.updateLastName(lastName, id);
        }
        if (!birthday.equals("defaultValue")) {
            resumeImplService.updateBirthDate(birthday, id);
        }
        if (!phone.equals("defaultValue")) {
            resumeImplService.updatePhone(phone, id);
        }
        if (!email.equals("defaultValue")) {
            resumeImplService.updateEmail(email, id);
        }
        if (!text.equals("defaultValue")) {
            resumeImplService.updateText(text, id);
        }
        model.addAttribute("user", user);
        model.addAttribute("resumes", resumeImplService.getAll().stream().filter(e -> e.getUser().equals(user)).collect(Collectors.toList()));
        return "personalArea";
    }
}
