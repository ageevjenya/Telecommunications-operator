package com.netcracker.app.domain.info.services.resumes;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.info.repositories.resumes.ResumeImplRepository;
import com.netcracker.app.domain.info.repositories.vacancies.VacancyImplRepository;
import com.netcracker.app.domain.users.entities.User;
import org.springframework.stereotype.Service;

@Service
public class ResumeImplService extends AbstractResumeService<ResumeImpl> {
    private final ResumeImplRepository repository;
    private final VacancyImplRepository vacancyImplRepository;

    public ResumeImplService(ResumeImplRepository repository, VacancyImplRepository vacancyImplRepository) {
        super(repository);
        this.repository = repository;
        this.vacancyImplRepository = vacancyImplRepository;
    }

    public ResumeImpl getByVacancyUser(VacancyImpl vacancy, User user) {
        return repository.getByVacancyAndUser(vacancy, user);
    }

    @Override
    public ResumeImpl getById(int id) throws Exception {
        if (repository.existsById(id)) {
            return repository.getById(id);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    public void updateAccepted(String name, int id) {
        ResumeImpl resume = repository.getById(id);
        resume.setAccepted(null);
        repository.saveAndFlush(resume);
    }

    @Override
    public void updateVacancyId(VacancyImpl vacancy, int id) throws Exception {
        if (repository.existsById(id)) {
            ResumeImpl resume = repository.getById(id);
            resume.setVacancy(vacancy);
            repository.saveAndFlush(resume);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    @Override
    public void updateFirstName(String firstName, int id) throws Exception {
        if (repository.existsById(id) && firstName != null) {
            ResumeImpl resume = repository.getById(id);
            resume.setFirstName(firstName);
            repository.saveAndFlush(resume);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    @Override
    public void updatePhone(String phone, int id) throws Exception {
        if (repository.existsById(id) && phone != null) {
            ResumeImpl resume = repository.getById(id);
            resume.setPhone(phone);
            repository.saveAndFlush(resume);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    @Override
    public void updateLastName(String lastName, int id) throws Exception {
        if (repository.existsById(id) && lastName != null) {
            ResumeImpl resume = repository.getById(id);
            resume.setLastName(lastName);
            repository.saveAndFlush(resume);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    @Override
    public void updateBirthDate(String birthDate, int id) throws Exception {
        if (repository.existsById(id) && birthDate != null) {
            ResumeImpl resume = repository.getById(id);
            resume.setBirthday(birthDate);
            repository.saveAndFlush(resume);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    @Override
    public void updateEmail(String email, int id) throws Exception {
        if (repository.existsById(id) && email != null) {
            ResumeImpl resume = repository.getById(id);
            resume.setEmail(email);
            repository.saveAndFlush(resume);
        } else {
            throw new Exception("Doesn't exist");
        }
    }

    @Override
    public void updateText(String text, int id) throws Exception {
        if (repository.existsById(id) && text != null) {
            ResumeImpl resume = repository.getById(id);
            resume.setText(text);
            repository.saveAndFlush(resume);
        } else {
            throw new Exception("Doesn't exist");
        }
    }
}
