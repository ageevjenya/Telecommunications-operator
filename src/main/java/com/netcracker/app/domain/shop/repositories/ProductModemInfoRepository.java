package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.ProductModemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductModemInfoRepository extends JpaRepository<ProductModemInfo, Integer> {
}
