package com.netcracker.app.domain.personalArea;

import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/personalArea")
public class personalAreaController {

    @Autowired
    private UserRepo userRepo;

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
            usedTariffMobile.append(", ");
            usedTariffMobile.append(usedMinutes);
            usedTariffMobile.append(", ");
            usedTariffMobile.append(usedSms);
            model.addAttribute("usedTariffMobile", usedTariffMobile);
        }
        model.addAttribute("user", user);
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
            usedTariffMobile.append("гб интернета: ");
            usedTariffMobile.append(usedInternet);
            usedTariffMobile.append(", минут: ");
            usedTariffMobile.append(usedMinutes);
            usedTariffMobile.append(", смс: ");
            usedTariffMobile.append(usedSms);

            model.addAttribute("usedTariffMobile", usedTariffMobile);
        }
        if (user.getTariffHome()!=null) {
            StringBuilder usedTariffHome = new StringBuilder();
//            Double usedInternet = user.getTariffHome().getGbInternet();
//            usedTariffMobile.append(usedInternet);
            usedTariffHome.append(" безлимитно gb");
            model.addAttribute("usedTariffHome", usedTariffHome);

        }
        model.addAttribute("user", user);
        return "personalArea";
    }

}
