package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.ProductTechInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTechInfoRepository extends JpaRepository<ProductTechInfo, Integer> {
}
