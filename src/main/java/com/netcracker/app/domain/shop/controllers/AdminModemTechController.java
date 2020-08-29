package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.entities.Devices;
import com.netcracker.app.domain.shop.entities.Modem;
import com.netcracker.app.domain.shop.entities.Tech;
import com.netcracker.app.domain.shop.services.ModemService;
import com.netcracker.app.domain.shop.services.TechService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/adminModemTech")
public class AdminModemTechController {
    private final ModemService modemService;
    private final TechService techService;

    public AdminModemTechController(ModemService modemService, TechService techService) {
        this.modemService = modemService;
        this.techService = techService;
    }

    @Transactional
    @GetMapping
    public String admin() {
        return "adminModemTech";
    }

    @Transactional
    @PostMapping("/create")
    public String create(@RequestParam String deviceName,
                         @RequestParam String name,
                         @RequestParam double price,
                         @RequestParam String description,
                         @RequestParam String shortDescription,
                         @RequestParam String specifications,
                         @RequestParam String imgUrl) throws Exception {
        if (deviceName.toLowerCase().equals("modem")) {
            Modem modem = new Modem(name, price, description, shortDescription, specifications, imgUrl);
            modemService.add(modem);
        } else if (deviceName.toLowerCase().equals("tech")) {
            Tech tech = new Tech(name, price, description, shortDescription, specifications, imgUrl);
            techService.add(tech);
        } else {
            throw new Exception();
        }

        return "adminModemTech";
    }

    @Transactional
    @PostMapping("/update")
    public String update(@RequestParam String deviceName,
                         @RequestParam int id,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) double price,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) String shortDescription,
                         @RequestParam(required = false) String specifications,
                         @RequestParam(required = false) String imgUrl) throws Exception {
        if (deviceName.toLowerCase().equals("modem")) {
            if (modemService.existsById(id)) {
                Modem modem = modemService.getById(id);
                setValues(modem, name, price, description, shortDescription, specifications, imgUrl);
            } else {
                throw new Exception();
            }
        } else if (deviceName.toLowerCase().equals("tech")) {
            if (techService.existsById(id)) {
                Tech tech = techService.getById(id);
                setValues(tech, name, price, description, shortDescription, specifications, imgUrl);
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }

        return "adminModemTech";
    }

    public void setValues(Devices device, String name, double price,
                          String description, String shortDescription,
                          String specifications, String imgUrl) {
        if (!name.isEmpty()) {
            device.setName(name);
        }
        if (price != 0) {
            device.setPrice(price);
        }
        if (!description.isEmpty()) {
            device.setDescription(description);
        }
        if (!shortDescription.isEmpty()) {
            device.setShortDescription(shortDescription);
        }
        if (!specifications.isEmpty()) {
            device.setSpecifications(specifications);
        }
        if (!imgUrl.isEmpty()) {
            device.setImgUrl(imgUrl);
        }
    }

    @Transactional
    @GetMapping("/delete")
    public String delete(@RequestParam String deviceName, @RequestParam int id) throws Exception {
        if (deviceName.toLowerCase().equals("modem")) {
            if (modemService.existsById(id)) {
                modemService.delete(id);
            }
        } else if (deviceName.toLowerCase().equals("tech")) {
            if (techService.existsById(id)) {
                techService.delete(id);
            }
        } else {
            throw new Exception();
        }
        return "adminModemTech";
    }
}
