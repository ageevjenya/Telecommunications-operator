package com.netcracker.app.domain.info.controllers.Networkcoveragemap;

import com.netcracker.app.domain.info.entities.networkcoveragemap.PointAcces;
import com.netcracker.app.domain.info.entities.networkcoveragemap.TypePointAcces;
import com.netcracker.app.domain.info.repositories.PointAccesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class NetworkcoveragemapRestController {
    @Autowired
    private PointAccesRepo pointAccesRepo;

    @PostMapping(value = "/networkcoveragemap/pointacces", headers = {"Content-type=application/json"})
    public Iterable<PointAcces> getPointAcces(@RequestBody TypePointAcces typePointAcces) {
        List<String> typepointschecked = new ArrayList<String>();
        typepointschecked.add(typePointAcces.name());
        Iterable<PointAcces> pointsacces = pointAccesRepo.selectPointAcces(typepointschecked);
        return pointsacces;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/networkcoveragemap/pointacces")
    public Iterable<PointAcces> ggggetPointAcces() {

        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
        return pointsacces;
    }

}
