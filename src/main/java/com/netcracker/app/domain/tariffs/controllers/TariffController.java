package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.entities.TariffOldMustDelete;
import com.netcracker.app.domain.tariffs.services.TariffService;

public interface TariffController<E extends TariffOldMustDelete, S extends TariffService<E>> {
}
