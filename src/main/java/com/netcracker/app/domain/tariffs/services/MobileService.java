package com.netcracker.app.domain.tariffs.services;

import com.netcracker.app.domain.tariffs.repositories.MobileRepository;
import com.netcracker.app.domain.tariffs.entities.Mobile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService extends AbstractTariffService<Mobile> {

    private final MobileRepository mobileRepository;

    public MobileService(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Override
    public boolean existsById(int id) {
        return mobileRepository.existsById(id);
    }

    @Override
    public void add(Mobile mobile) {
        mobileRepository.saveAndFlush(mobile);
    }

    @Override
    public void delete(int id) {
        mobileRepository.deleteById(id);
    }

    @Override
    public List<Mobile> getAll() {
        return mobileRepository.findAll();
    }

    @Override
    public Iterable<Mobile> getAllByName(String name) {
        return mobileRepository.getAllByName(name);
    }

    public Mobile getById(int id) {
        return mobileRepository.getById(id);
    }

    @Override
    public void updateName(String name, int id) {
        if (mobileRepository.existsById(id) && name != null) {
            Mobile mobile = mobileRepository.getById(id);
            mobile.setName(name);
            mobileRepository.saveAndFlush(mobile);
        }
    }

    @Override
    public void updatePriceOfMonth(double priceOfMonth, int id) {
        if (mobileRepository.existsById(id) && priceOfMonth != 0) {
            Mobile mobile = mobileRepository.getById(id);
            mobile.setPriceOfMonth(priceOfMonth);
            mobileRepository.saveAndFlush(mobile);
        }
    }

    @Override
    public void updateDescription(String description, int id) {
        if (mobileRepository.existsById(id) && description != null) {
            Mobile mobile = mobileRepository.getById(id);
            mobile.setDescription(description);
            mobileRepository.saveAndFlush(mobile);
        }
    }

    @Override
    public void updateGbInternet(double gbInternet, int id) {
        if (mobileRepository.existsById(id) && gbInternet != 0) {
            Mobile mobile = mobileRepository.getById(id);
            mobile.setGbInternet(gbInternet);
            mobileRepository.saveAndFlush(mobile);
        }
    }

    public void updateMinutes(int minutes, int id) {
        if (mobileRepository.existsById(id) && minutes != 0) {
            Mobile mobile = mobileRepository.getById(id);
            mobile.setMinutes(minutes);
            mobileRepository.saveAndFlush(mobile);
        }
    }

    public void updateSms(int sms, int id) {
        if (mobileRepository.existsById(id) && sms != 0) {
            Mobile mobile = mobileRepository.getById(id);
            mobile.setSms(sms);
            mobileRepository.saveAndFlush(mobile);
        }
    }
}