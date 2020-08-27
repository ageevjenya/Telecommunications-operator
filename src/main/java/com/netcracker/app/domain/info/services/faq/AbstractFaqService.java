package com.netcracker.app.domain.info.services.faq;

import com.netcracker.app.domain.info.entities.faq.AbstractFaq;
import com.netcracker.app.domain.info.repositories.faq.FaqRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractFaqService<E extends AbstractFaq> implements FaqService<E> {
    private final FaqRepository<E> repository;

    protected AbstractFaqService(FaqRepository repository) {
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
    public void updateQuestion(String question, int id) throws Exception {
        if (repository.existsById(id)) {
            E e = repository.getOne(id);
            e.setQuestion(question);
            repository.saveAndFlush(e);
        }
        throw new Exception("Id doesn't exist");
    }

    @Override
    public void updateAnswer(String answer, int id) throws Exception {
        if (repository.existsById(id)) {
            E e = repository.getOne(id);
            e.setAnswer(answer);
            repository.saveAndFlush(e);
        }
        throw new Exception("Id doesn't exist");
    }

    @Override
    public void add(E e) {
        repository.saveAndFlush(e);
    }
}
