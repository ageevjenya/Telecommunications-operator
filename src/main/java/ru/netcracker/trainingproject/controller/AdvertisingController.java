package ru.netcracker.trainingproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.netcracker.trainingproject.domain.Advertising;

import ru.netcracker.trainingproject.domain.User;
import ru.netcracker.trainingproject.repository.AdvertisingRepo;


import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class AdvertisingController {
    private final AdvertisingRepo adverRepo;

    @Value("${upload.path}")
    private String uploadPath;

    public AdvertisingController(AdvertisingRepo adverRepo) {
        this.adverRepo = adverRepo;
    }

    @GetMapping("/advertising")
    public String advertising(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Advertising> advertisings = adverRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            advertisings = adverRepo.findByName(filter);
        } else {
            advertisings = adverRepo.findAll();
        }

        model.addAttribute("advertisings", advertisings);
        model.addAttribute("filter", filter);
        return "advertising";
    }

    @Transactional
    @PostMapping("/advertising/delete")
    public String deleteAdvertising(@RequestParam Integer advertisingId, Map<String,Object> model) {
        List<Advertising> advertisings = adverRepo.findById(advertisingId);
        if (advertisings.isEmpty()) {
            model.put("deleteIdCheck","No advertising with such index!");
        }
        else {
            adverRepo.deleteById(advertisingId);
        }
        Iterable<Advertising> adverRepoAll = adverRepo.findAll();
        model.put("advertisings",adverRepoAll);
        return "advertising";
    }

    @Transactional
    @PostMapping("/advertising/update")
    public String updateAdvertising(@RequestParam Integer advertisingId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String description,
                                 Map<String,Object> model) {
        List<Advertising> advertisings = adverRepo.findById(advertisingId);
        if (advertisings.isEmpty()) {
            model.put("updateIdCheck","Advertising with such index does not exist!");
        }
        else {
            if (!name.isEmpty()) {
                adverRepo.setNameFor(name,advertisingId);
            }
            if (!description.isEmpty()) {
                adverRepo.setDescriptionFor(description,advertisingId);
            }
        }
        Iterable<Advertising> adverRepoAll = adverRepo.findAll();
        model.put("advertisings",adverRepoAll);
        return "advertising";
    }


    @PostMapping("/advertising")
    public String advertisingAdd(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String description,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Advertising advertising = new Advertising(description,name,user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            advertising.setFilename(resultFilename);
        }

        adverRepo.save(advertising);

        Iterable<Advertising> advertisings = adverRepo.findAll();

        model.put("advertisings", advertisings);

        return "advertising";
    }
}
