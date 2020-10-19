package com.netcracker.app.domain.balance.repositories.payment;

import com.netcracker.app.domain.balance.entities.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PaymentRepository <E extends Payment> extends JpaRepository<E, Integer> {
}
