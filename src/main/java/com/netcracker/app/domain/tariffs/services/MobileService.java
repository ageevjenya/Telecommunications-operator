package com.netcracker.app.domain.tariffs.services;

import com.netcracker.app.domain.tariffs.repositories.TariffMobileRepo;
import com.netcracker.app.domain.tariffs.entities.TariffMobile;
import org.springframework.stereotype.Service;

@Service
public class MobileService extends AbstractTariffService<TariffMobile> {

    private final TariffMobileRepo tariffMobileRepo;

    public MobileService(TariffMobileRepo tariffMobileRepo) {
        super(tariffMobileRepo);
        this.tariffMobileRepo = tariffMobileRepo;
    }

    @Override
    public Iterable<TariffMobile> getAllByName(String name) {
        return tariffMobileRepo.getAllByName(name);
    }

    public TariffMobile getById(int id) {
        return tariffMobileRepo.getById(id);
    }

    @Override
    public void updateName(String name, int id) {
        if (tariffMobileRepo.existsById(id) && name != null) {
            TariffMobile tariffMobile = tariffMobileRepo.getById(id);
            tariffMobile.setName(name);
            tariffMobileRepo.saveAndFlush(tariffMobile);
        }
    }

    @Override
    public void updatePriceOfMonth(double priceOfMonth, int id) {
        if (tariffMobileRepo.existsById(id) && priceOfMonth != 0) {
            TariffMobile tariffMobile = tariffMobileRepo.getById(id);
            tariffMobile.setPriceOfMonth(priceOfMonth);
            tariffMobileRepo.saveAndFlush(tariffMobile);
        }
    }

    @Override
    public void updateDescription(String description, int id) {
        if (tariffMobileRepo.existsById(id) && description != null) {
            TariffMobile tariffMobile = tariffMobileRepo.getById(id);
            tariffMobile.setDescription(description);
            tariffMobileRepo.saveAndFlush(tariffMobile);
        }
    }

    @Override
    public void updateGbInternet(double gbInternet, int id) {
        if (tariffMobileRepo.existsById(id) && gbInternet != 0) {
            TariffMobile tariffMobile = tariffMobileRepo.getById(id);
            tariffMobile.setGbInternet(gbInternet);
            tariffMobileRepo.saveAndFlush(tariffMobile);
        }
    }

    public void updateMinutes(int minutes, int id) {
        if (tariffMobileRepo.existsById(id) && minutes != 0) {
            TariffMobile tariffMobile = tariffMobileRepo.getById(id);
            tariffMobile.setMinutes(minutes);
            tariffMobileRepo.saveAndFlush(tariffMobile);
        }
    }

    public void updateSms(int sms, int id) {
        if (tariffMobileRepo.existsById(id) && sms != 0) {
            TariffMobile tariffMobile = tariffMobileRepo.getById(id);
            tariffMobile.setSms(sms);
            tariffMobileRepo.saveAndFlush(tariffMobile);
        }
    }
}