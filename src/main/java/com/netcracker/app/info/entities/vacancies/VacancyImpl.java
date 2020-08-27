package com.netcracker.app.info.entities.vacancies;

import com.netcracker.app.info.entities.resumes.ResumeImpl;
import net.minidev.json.annotate.JsonIgnore;

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

    @OneToMany(mappedBy = "vacancy")
    @JsonIgnore
    Set<ResumeImpl> resumes;

    public static String[] getFieldsNames() {
        String[] names = {"name", "text"};
        return names;
    }
}
