package com.netcracker.app.domain.info.services.resumes;

import com.netcracker.app.domain.info.entities.resumes.AbstractResume;
import com.netcracker.app.domain.info.repositories.resumes.ResumeRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractResumeService<E extends AbstractResume> implements ResumeService<E> {

    private final ResumeRepository repository;

    protected AbstractResumeService(ResumeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(E e) {
        repository.saveAndFlush(e);
    }

    @Override
    public void delete(int id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<E> getAll() {
        return repository.findAll();
    }
}
