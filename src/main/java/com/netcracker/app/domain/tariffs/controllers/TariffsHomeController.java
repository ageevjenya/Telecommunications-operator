package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.balance.entities.expenses.Expenses;
import com.netcracker.app.domain.balance.services.BalanceImplService;
import com.netcracker.app.domain.balance.services.expenses.ExpensesImplService;
import com.netcracker.app.domain.balance.services.expenses.ExpensesService;
import com.netcracker.app.domain.notifications.NotificationsServiсe;
import com.netcracker.app.domain.tariffs.entities.TariffHome;

import com.netcracker.app.domain.tariffs.repositories.TariffHomeRepo;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tariffsHome")
public class TariffsHomeController {

    private final TariffHomeRepo tariffHomeRepository;
    private final UserRepo userRepo;
    private final BalanceImplService balanceService;
    private final NotificationsServiсe notificationsServiсe;
    private final ExpensesImplService expensesService;

    public TariffsHomeController(TariffHomeRepo tariffHomeRepository, UserRepo userRepo, BalanceImplService balanceService, NotificationsServiсe notificationsServiсe, ExpensesImplService expensesService) {
        this.tariffHomeRepository = tariffHomeRepository;
        this.userRepo = userRepo;
        this.balanceService = balanceService;
        this.notificationsServiсe = notificationsServiсe;
        this.expensesService = expensesService;
    }

    @GetMapping
    public String internet(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        List<TariffHome> internetRepositorys;
        if (filter != null && !filter.isEmpty()) {
            internetRepositorys = tariffHomeRepository.findBeforeMaxSpeed(filter);
        } else {
            internetRepositorys = tariffHomeRepository.findAll();
        }
        TariffHome userTariffHomes = null;
        if (user != null) {
            userTariffHomes = user.getTariffHome();
        }
        model.addAttribute("tariffHomes", internetRepositorys);
        model.addAttribute("filter", filter);
        model.addAttribute("user", user);
        model.addAttribute("userTariffHomes", userTariffHomes);
        return "tariffsHome";
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String add(@RequestParam String name,
                      @RequestParam String priceOfMonth,
                      @RequestParam String speedInternet,
                      @RequestParam String description,
                      Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "redirect:/login";
        }

        TariffHome tariffHome = new TariffHome(name, Double.valueOf(priceOfMonth), Integer.valueOf(speedInternet), description);
        tariffHomeRepository.save(tariffHome);

        return "redirect:/tariffsHome";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam String tariffId, Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "redirect:/login";
        }
        Long longTariffId = Long.valueOf(tariffId);
        TariffHome packInternet = tariffHomeRepository.getOne(longTariffId);

        if (packInternet!=null) {
            tariffHomeRepository.deleteById(longTariffId);
        }
        return  "redirect:/tariffsHome";
    }


    @PostMapping("/update")
    public String update(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double priceOfMonth,
            @RequestParam(required = false) Integer speedInternet,
            @RequestParam(required = false) String description,
            @RequestParam Map<String, String> form,
            @RequestParam("tariffId") String tariffHomeId, Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "login";
        }
        TariffHome tariffHome = tariffHomeRepository.getOne(Long.valueOf(tariffHomeId));
        if (tariffHome != null) {
            if (!name.isEmpty()) {
                tariffHome.setName(name);
            }
            if (priceOfMonth!= null) {
                tariffHome.setPriceOfMonth(Double.valueOf(priceOfMonth));
            }
            if (speedInternet!= null) {
                tariffHome.setSpeedInternet(Integer.valueOf(speedInternet));
            }
            if (!description.isEmpty()) {
                tariffHome.setDescription(description);
            }
            tariffHomeRepository.save(tariffHome);
        }

        return "redirect:/tariffsHome";
    }

    @PostMapping("/connect")
    public String userСonnectTariff(@RequestParam("tariffHomeId") Long tariffHomeId, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "login";
        }

        TariffHome tariffHome = tariffHomeRepository.getOne(tariffHomeId);
        user.setTariffHome(tariffHome);
        userRepo.save(user);
        balanceService.updateBalance(tariffHome.getPriceOfMonth(),user.getBalance().getId());
        Expenses expenses = expensesService.getById(new Expenses().getId());
        expensesService.updateExpenses(user.getTariffMobile().getPriceOfMonth(),new GregorianCalendar(),"Домашний интернет",expenses.getId(),user);
        String description = "Вы подключили тариф: " + tariffHome.getDescription();
        notificationsServiсe.AddNewNotificationInBDonDesctiption(description);
        return "redirect:/tariffsHome";
    }
}
