package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    @Query(nativeQuery = true, value = "select * from user_order where user_id = :id")
    List<UserOrder> findAllByUserId(@Param("id") long id);
}
