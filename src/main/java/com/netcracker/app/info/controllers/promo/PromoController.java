package com.netcracker.app.info.controllers.promo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.netcracker.app.info.entities.promo.Promo;

import com.netcracker.app.users.User;
import com.netcracker.app.info.repositories.promo.PromoRepo;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PromoController {
    private final PromoRepo promoRepo;

    @Value("${upload.path}")
    private String uploadPath;

    public PromoController(PromoRepo promoRepo) {
        this.promoRepo = promoRepo;
    }

    @GetMapping("/promo")
    public String promo(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Promo> promos = promoRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            promos = promoRepo.findByName(filter);
        } else {
            promos = promoRepo.findAll();
        }

        model.addAttribute("promos", promos);
        model.addAttribute("filter", filter);

        return "promo";
    }

    @PostMapping("/promo")
    public String promoAdd(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String startDate,
            @RequestParam String endDate,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Promo promo = new Promo(name,description, startDate,endDate, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            promo.setFilename(resultFilename);
        }

        promoRepo.save(promo);

        Iterable<Promo> promos = promoRepo.findAll();

        model.put("promos", promos);

        return "promo";
    }

    @Transactional
    @PostMapping("/promo/delete")
    public String deletePromos(@RequestParam Integer promoId, Map<String,Object> model) {
        List<Promo> promos = promoRepo.findById(promoId);
        if (promos.isEmpty()) {
            model.put("deleteIdCheck","No promo with such index!");
        }
        else {
            promoRepo.deleteById(promoId);
        }
        Iterable<Promo> promoRepAll = promoRepo.findAll();
        model.put("promos",promoRepAll);
        return "promo";
    }

    @Transactional
    @PostMapping("/promo/update")
    public String updatePromo(@RequestParam Integer promoId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String description,
                                 @RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate,
                                 Map<String,Object> model) {
        List<Promo> promos = promoRepo.findById(promoId);
        if (promos.isEmpty()) {
            model.put("updateIdCheck","Promo with such index does not exist!");
        }
        else {
            if (!name.isEmpty()) {
                promoRepo.setNameFor(name,promoId);
            }
            if (!description.isEmpty()) {
                promoRepo.setDescriptionFor(description,promoId);
            }
            if (!startDate.isEmpty()) {
                promoRepo.setStartDateFor(startDate,promoId);
            }
            if (!endDate.isEmpty()) {
                promoRepo.setEndDateFor(endDate,promoId);
            }
        }
        Iterable<Promo> promoRepAll = promoRepo.findAll();
        model.put("promos",promoRepAll);
        return "promo";
    }
}