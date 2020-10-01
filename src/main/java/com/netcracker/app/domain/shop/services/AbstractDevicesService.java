package com.netcracker.app.domain.shop.services;

import com.netcracker.app.domain.shop.entities.Devices;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractDevicesService<E extends Devices> implements DevicesService<E> {

}
