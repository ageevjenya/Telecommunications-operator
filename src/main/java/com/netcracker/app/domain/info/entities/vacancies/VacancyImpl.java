package com.netcracker.app.domain.info.entities.vacancies;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class VacancyImpl extends AbstractVacancy {

    public VacancyImpl(String name, String text) {
        super(name, text);
    }

    public VacancyImpl() {
        super();
    }

    public Set<ResumeImpl> getResumes() {
        return resumes;
    }

    public void setResumes(Set<ResumeImpl> resumes) {
        this.resumes = resumes;
    }

    @OneToMany
    Set<ResumeImpl> resumes;
}
