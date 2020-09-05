package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.entities.Tariff;
import com.netcracker.app.domain.tariffs.services.TariffService;

public interface TariffController<E extends Tariff, S extends TariffService<E>> {
}
