package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.ImgModem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImgModemRepository extends JpaRepository<ImgModem, Integer> {
    List<ImgModem> findAllByModemId(int id);
}
