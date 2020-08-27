package com.netcracker.app.shop.tariffs.controllers;

import com.netcracker.app.shop.tariffs.entities.Tariff;
import com.netcracker.app.shop.tariffs.services.TariffService;
import com.netcracker.app.shop.tariffs.services.AbstractTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractTariffController<E extends Tariff, S extends TariffService<E>>
        implements TariffController<E, S> {

    protected final AbstractTariffService tariffService;

    @Autowired
    protected AbstractTariffController(@Qualifier("abstractTariffService") AbstractTariffService tariffService) {
        this.tariffService = tariffService;
    }
}
