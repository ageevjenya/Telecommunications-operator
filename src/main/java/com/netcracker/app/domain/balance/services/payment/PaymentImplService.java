package com.netcracker.app.domain.balance.services.payment;

import com.netcracker.app.domain.balance.entities.payment.PaymentImpl;
import com.netcracker.app.domain.balance.repositories.payment.PaymentImplRepository;
import com.netcracker.app.domain.balance.repositories.payment.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentImplService extends AbstractPaymentService<PaymentImpl> {
    private final PaymentImplRepository repository;

    public PaymentImplService(PaymentImplRepository repository, PaymentRepository paymentRepository) {
        super(paymentRepository);
        this.repository = repository;
    }

}
