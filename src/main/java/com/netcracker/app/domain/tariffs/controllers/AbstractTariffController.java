package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.entities.TariffOldMustDelete;
import com.netcracker.app.domain.tariffs.services.TariffService;
import com.netcracker.app.domain.tariffs.services.AbstractTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractTariffController<E extends TariffOldMustDelete, S extends TariffService<E>>
        implements TariffController<E, S> {

    protected final AbstractTariffService tariffService;

    @Autowired
    protected AbstractTariffController(@Qualifier("abstractTariffService") AbstractTariffService tariffService) {
        this.tariffService = tariffService;
    }
}
