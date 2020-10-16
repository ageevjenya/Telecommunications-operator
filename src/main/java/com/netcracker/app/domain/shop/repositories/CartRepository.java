package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
