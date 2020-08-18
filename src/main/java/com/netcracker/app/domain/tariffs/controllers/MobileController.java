package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.entities.Mobile;
import com.netcracker.app.domain.tariffs.services.MobileService;
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
    @RequestMapping("tariffs")
    public String index(Model model) {
        model.addAttribute("mobileTariffs", mobileService.getAll());
        return "tariffs";
    }

    @Transactional
    @PostMapping("search")
    public String find(@RequestParam String name, Map<String, Object> model) {
        model.put("mobileTariffs", mobileService.getAllByName(name));
        return "tariffs";
    }

    @Transactional
    @PostMapping("create") //it doesn't add (without any errors)
    public String create(@ModelAttribute("mobileTariff") Mobile mobile, Map<String, Object> model) {
        mobileService.add(mobile);
        model.put("mobileTariffs", mobileService.getAll());
        return "redirect:/tariffs";
        /*<input type="text" name="name" value="{{#mobileTariff.name}}{{mobileTariff.name}}{{/mobileTariff.name}}" placeholder="Enter the name" />
            <input type="text" name="priceOfMonth" value="{{#mobileTariff.priceOfMonth}}{{mobileTariff.priceOfMonth}}{{/mobileTariff.priceOfMonth}}" placeholder="Enter price of month" />
            <input type="text" name="minutes" value="{{#mobileTariff.minutes}}{{mobileTariff.minutes}}{{/mobileTariff.minutes}}" placeholder="Enter amount of minutes" />
            <input type="text" name="sms" value="{{#mobileTariff.sms}}{{mobileTariff.sms}}{{/mobileTariff.sms}}" placeholder="Enter amount of sms" />
            <input type="text" name="description" value="{{#mobileTariff.description}}{{mobileTariff.description}}{{/mobileTariff.description}}" placeholder="Enter description" />
            <button type="submit">Create</button>*/
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
