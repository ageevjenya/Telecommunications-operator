package com.netcracker.app.domain.index;

import com.netcracker.app.domain.info.entities.networkcoveragemap.PointAcces;
import com.netcracker.app.domain.info.repositories.PointAccesRepo;
import com.netcracker.app.domain.info.services.contacts.ContactsServiceImpl;
import com.netcracker.app.domain.info.services.faq.FaqImplService;
import com.netcracker.app.domain.info.services.vacancies.VacancyImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class index{
    @Autowired
    private PointAccesRepo pointAccesRepo;
    @Autowired
    private ContactsServiceImpl contactsService;
    @Autowired
    private VacancyImplService vacancyImplService;
    @Autowired
    private FaqImplService faqImplService;
    public index(){}
    public index(PointAccesRepo pointAccesRepo, ContactsServiceImpl contactsService, VacancyImplService vacancyImplService,
                 FaqImplService faqImplService) {
        this.pointAccesRepo = pointAccesRepo;
        this.contactsService = contactsService;
        this.vacancyImplService = vacancyImplService;
        this.faqImplService = faqImplService;
    }

    @GetMapping
    public String index(Model model) {
        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
//        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("pointsacces", pointsacces);
        model.addAttribute("contacts", contactsService.getAll());
        model.addAttribute("vacancies", vacancyImplService.getAll());
        model.addAttribute("faq", faqImplService.getAll());
        return "index";
    }


}

