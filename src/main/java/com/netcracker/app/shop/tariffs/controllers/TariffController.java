package com.netcracker.app.shop.tariffs.controllers;

import com.netcracker.app.shop.tariffs.entities.Tariff;
import com.netcracker.app.shop.tariffs.services.TariffService;

public interface TariffController<E extends Tariff, S extends TariffService<E>> {
}
