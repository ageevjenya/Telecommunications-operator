package com.netcracker.app.domain.requests;

import com.netcracker.app.domain.users.entities.Role;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestRestController {


    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/requests/all", headers = {"Content-type=application/json"})
    public Iterable<Request> requests() {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user.getRoles().contains(Role.USER) && user.getRoles().size() == 1 ) {
            Iterable<Request> requests = requestRepo.findByUserByOrderByActiveDesc(user);
            return requests;
        }
        Iterable<Request> requests = requestRepo.findByOrderByActiveDesc();
        return requests;
    }

    @PostMapping(value = "/requests/info", headers = {"Content-type=application/json"})
    public Request requestInfo(@RequestBody Request request, @AuthenticationPrincipal User user) {
        Request requestBD = requestRepo.findById(request.getId()).get();
        return requestBD;
    }

    @PostMapping(value = "/requests/changeActive", headers = {"Content-type=application/json"})
    public Request changeActiveRequest(@RequestBody Request request) {
        Request requestBD = requestRepo.findById(request.getId()).get();
        requestBD.setActive(!request.isActive());
        requestRepo.save(requestBD);
        return requestBD;
    }

}
