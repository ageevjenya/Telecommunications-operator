package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.entities.TariffHome;
import com.netcracker.app.domain.tariffs.repositories.TariffHomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TariffsHomeRestController {

    @Autowired
    private TariffHomeRepo tariffHomeRepository;
    
    @RequestMapping(method = RequestMethod.GET, value = "/tariffsHome/get")
    public Collection<TariffHome> getTariffsHome(){
        return tariffHomeRepository.findAll();
    }
}
