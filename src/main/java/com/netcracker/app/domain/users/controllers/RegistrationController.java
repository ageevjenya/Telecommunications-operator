package com.netcracker.app.domain.users.controllers;

import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.balance.repositories.BalanceRepo;
import com.netcracker.app.domain.shop.entities.Cart;
import com.netcracker.app.domain.shop.repositories.CartRepository;
import com.netcracker.app.domain.users.entities.Role;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.entities.UserUsedTariffMobile;
import com.netcracker.app.domain.users.repositories.UserRepo;
import com.netcracker.app.domain.users.repositories.UserUsedTariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserRepo userRepo;
    private final UserUsedTariffRepo userUsedTariffRepo;
    private final CartRepository cartRepository;
    private final BalanceRepo balanceRepo;

    public RegistrationController(UserRepo userRepo, UserUsedTariffRepo userUsedTariffRepo, CartRepository cartRepository, BalanceRepo balanceRepo) {
        this.userRepo = userRepo;
        this.userUsedTariffRepo = userUsedTariffRepo;
        this.cartRepository = cartRepository;
        this.balanceRepo = balanceRepo;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(@RequestParam(required = false) String username,
                          @RequestParam(required = false) String password,
                          @RequestParam(required = false) String number,
                          @RequestParam(required = false) String lastName,
                          @RequestParam(required = false) String firstName,
                          @RequestParam(required = false) String middleName,
                          @RequestParam(required = false) String birthday,   Model model) {
        System.out.println(birthday);//User user,

        User userFromDb = userRepo.findByUsername(username);
        if (userFromDb != null) {
            model.addAttribute("message","Пользователь уже существет!");
            return "registration";
        }
        if (username == null || password == null || number == null || lastName == null ||
                firstName == null || middleName == null || birthday == null) {
            model.addAttribute("message","Заполните все данные, пожайлуста");
            return "registration";
        }

        User user = new User(username, password, firstName, middleName, lastName, LocalDate.parse(birthday),
                number, true,   Collections.singleton(Role.USER));
        if(userRepo.count()==0) {
            user.setRoles( Collections.singleton(Role.ADMIN));
        }
        Balance balance = new Balance(user,0,user.getNumber());
        UserUsedTariffMobile userUsedTariffMobile = new UserUsedTariffMobile(user, 0, 0, 0);
        user.setUserUsedTariffMobile(userUsedTariffMobile);
        user.setBalance(balance);
        Cart cart = new Cart();
        user.setCart(cart);
        cart.setUser(user);
        userRepo.save(user);
        cartRepository.save(cart);
        userUsedTariffRepo.save(userUsedTariffMobile);
        balanceRepo.save(balance);
        return "redirect:/login";
    }
}
