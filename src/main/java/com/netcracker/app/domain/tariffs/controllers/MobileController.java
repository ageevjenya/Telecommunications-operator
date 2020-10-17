package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.entities.TariffHome;
import com.netcracker.app.domain.tariffs.entities.TariffMobile;
import com.netcracker.app.domain.tariffs.services.MobileService;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@Controller
public class MobileController extends AbstractTariffController<TariffMobile, MobileService> {

    private final MobileService mobileService;
    private final UserRepo userRepo;

    public MobileController(MobileService mobileService, UserRepo userRepo) {
        super(mobileService);
        this.mobileService = mobileService;
        this.userRepo = userRepo;
    }

    @Transactional
    @GetMapping("tariffs")
    public String tariff(@RequestParam(required = false) String filter, Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("mobileTariffs", mobileService.getAllByName(filter));
        } else {
            model.addAttribute("mobileTariffs", mobileService.getAll());
        }
        TariffMobile userTariffMobile = null;
        if (user != null)
        {
            userTariffMobile = user.getTariffMobile();
        }
        model.addAttribute("filter", filter);
        model.addAttribute("userTariffMobile", userTariffMobile);
        return "tariffs";
    }

    @Transactional
    @PostMapping("createMobile")
    public String create(@RequestParam String name,
                         @RequestParam double priceOfMonth,
                         @RequestParam int minutes,
                         @RequestParam int sms,
                         @RequestParam double gbInternet,
                         @RequestParam String description,
                         Map<String, Object> model) {
        TariffMobile tariffMobile = new TariffMobile(minutes, sms, priceOfMonth, name, description, gbInternet);
        mobileService.add(tariffMobile);
        model.put("mobileTariffs", mobileService.getAll());
        return "redirect:/tariffs";
    }

    @Transactional
    @PostMapping("update")
    public String update(@RequestParam Long id,
                         @RequestParam(required = false, defaultValue = "defaultValue") String name,
                         @RequestParam(required = false, defaultValue = "0.0") double priceOfMonth,
                         @RequestParam(required = false, defaultValue = "0") int minutes,
                         @RequestParam(required = false, defaultValue = "0") int sms,
                         @RequestParam(required = false, defaultValue = "0") double gbInternet,
                         @RequestParam(required = false, defaultValue = "defaultValue") String description,
                         Map<String, Object> model) {
            if (!name.equals("defaultValue")) {
                mobileService.updateName(name, id);
            }
            if (priceOfMonth != 0) {
                mobileService.updatePriceOfMonth(priceOfMonth, id);
            }
            if (minutes != 0) {
                mobileService.updateMinutes(minutes, id);
            }
            if (sms != 0) {
                mobileService.updateSms(sms, id);
            }
        if (gbInternet != 0) {
            mobileService.updateGbInternet(gbInternet, id);
        }
        if (!description.equals("defaultValue")) {
                mobileService.updateDescription(description, id);
            }
        model.put("mobileTariffs", mobileService.getAll());
        return "redirect:/tariffs";
    }

    @Transactional
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Map<String, Object> model) throws Exception {
        mobileService.delete(id);
        model.put("mobileTariffs", mobileService.getAll());
        return "redirect:/tariffs";
    }

    @Transactional
    @PostMapping("/connect")
    public String userСonnectsTariff(@RequestParam("tariffMobileId") Long tariffMobileId, Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "login";
        }
        TariffMobile tariffMobile = mobileService.getById(tariffMobileId);
        user.setTariffMobile(tariffMobile);
        userRepo.save(user);

        return "redirect:/tariffs";
    }
}
