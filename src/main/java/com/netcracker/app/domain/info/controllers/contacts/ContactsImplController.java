package com.netcracker.app.domain.info.controllers.contacts;

import com.netcracker.app.domain.info.services.contacts.ContactsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;

@Controller
public class ContactsImplController {
    private ContactsServiceImpl service;

    public ContactsImplController(ContactsServiceImpl service) {
        this.service = service;
    }

    @Transactional
    @GetMapping("contacts")
    public String contacts(Model model) {
        model.addAttribute("contacts", service.getAll());
        return "contacts";
    }

/*    @Transactional
    @PostMapping("create")
    public String create(@ModelAttribute("info") CompanyInfoImpl companyInfo, Map<String, Object> model) {
        service.add(companyInfo);
        Iterable<CompanyInfoImpl> companyInfoIterable = service.getAll();
        model.put("info", companyInfoIterable);
        return "redirect:/contacts";
    }*/
}
