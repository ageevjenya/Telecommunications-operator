package com.netcracker.app.domain.info.entities.resumes;

import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ResumeImpl extends AbstractResume {
    public ResumeImpl() {
        super();
    }

    public ResumeImpl(/*int vacancyId, */String firstName, String lastName, String birthDate, String phone,
                      String email, String text, VacancyImpl vacancy) throws Exception {
        super(/*vacancyId, */firstName, lastName, birthDate, phone, email, text);
        this.vacancy = vacancy;
    }

    public VacancyImpl getVacancy() {
        return vacancy;
    }

    public void setVacancy(VacancyImpl vacancy) {
        this.vacancy = vacancy;
    }

    @ManyToOne
    private VacancyImpl vacancy;
}
