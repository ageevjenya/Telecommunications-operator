package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.ImgModem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgModemRepository extends JpaRepository<ImgModem, Integer> {
    List<ImgModem> findAllByModemId(int id);
}
