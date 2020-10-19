package com.netcracker.app.domain.balance.services.payment;

import com.netcracker.app.domain.balance.entities.payment.AbstractPayment;
import com.netcracker.app.domain.balance.repositories.payment.PaymentRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPaymentService<E extends AbstractPayment> implements PaymentService<E> {
    private final PaymentRepository<E> repository;

    protected AbstractPaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public E getById(int id) throws Exception {
        if (repository.existsById(id)) {
            return repository.getOne(id);
        }
        throw new Exception("Id doesn't exist");
    }

    @Override
    public Iterable<E> getAll() {
        return repository.findAll();
    }

    @Override
    public void updateName(String name, int id) throws Exception {
        if (repository.existsById(id)) {
            E e = repository.getOne(id);
            e.setCardName(name);
            repository.saveAndFlush(e);
        }
        throw new Exception("Id doesn't exist");
    }

    @Override
    public void updateSurname(String surname, int id) throws Exception {
        if (repository.existsById(id)) {
            E e = repository.getOne(id);
            e.setCardSurname(surname);
            repository.saveAndFlush(e);
        }
        throw new Exception("Id doesn't exist");
    }

    @Override
    public void updateNumber(Integer number, int id) throws Exception {
        if (repository.existsById(id)) {
            E e = repository.getOne(id);
            e.setCardNumber(number);
            repository.saveAndFlush(e);
        }
        throw new Exception("Id doesn't exist");
    }


    @Override
    public void add(E e) {
        repository.saveAndFlush(e);
    }
}
