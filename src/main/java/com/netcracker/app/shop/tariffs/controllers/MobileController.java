package com.netcracker.app.shop.tariffs.controllers;

import com.netcracker.app.shop.tariffs.entities.Mobile;
import com.netcracker.app.shop.tariffs.services.MobileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@Controller
public class MobileController extends AbstractTariffController<Mobile, MobileService> {

    private final MobileService mobileService;

    public MobileController(MobileService mobileService) {
        super(mobileService);
        this.mobileService = mobileService;
    }

    @Transactional
    @GetMapping("tariffs")
    public String tariff(@RequestParam(required = false) String filter, Model model) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("mobileTariffs", mobileService.getAllByName(filter));
        } else {
            model.addAttribute("mobileTariffs", mobileService.getAll());
        }
        model.addAttribute("filter", filter);
        return "tariffs";
    }

    @Transactional
    @PostMapping("createMobile")
    public String create(@RequestParam String name,
                         @RequestParam double priceOfMonth,
                         @RequestParam int minutes,
                         @RequestParam int sms,
                         @RequestParam String description,
                         Map<String, Object> model) {
        Mobile mobile = new Mobile(minutes, sms, priceOfMonth, name, description);
        mobileService.add(mobile);
        model.put("mobileTariffs", mobileService.getAll());
        return "redirect:/tariffs";
    }

    @Transactional
    @PostMapping("update")
    public String update(@RequestParam Integer id,
                         @RequestParam(required = false, defaultValue = "defaultValue") String name,
                         @RequestParam(required = false, defaultValue = "0.0") double priceOfMonth,
                         @RequestParam(required = false, defaultValue = "0") int minutes,
                         @RequestParam(required = false, defaultValue = "0") int sms,
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
            if (!description.equals("defaultValue")) {
                mobileService.updateDescription(description, id);
            }
        model.put("mobileTariffs", mobileService.getAll());
        return "redirect:/tariffs";
    }

    @Transactional
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Map<String, Object> model) {
        mobileService.delete(id);
        model.put("mobileTariffs", mobileService.getAll());
        return "redirect:/tariffs";
    }
}
