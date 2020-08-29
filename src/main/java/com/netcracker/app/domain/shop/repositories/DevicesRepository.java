package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DevicesRepository<E extends Devices> extends JpaRepository<E, Integer> {
}
