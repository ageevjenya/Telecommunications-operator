package com.netcracker.app.domain.tariffs.services;

import com.netcracker.app.domain.tariffs.repositories.TariffRepository;
import com.netcracker.app.domain.tariffs.entities.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AbstractTariffService<E extends Tariff> implements TariffService<E> {

}
