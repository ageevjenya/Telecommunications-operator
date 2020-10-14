package com.netcracker.app.domain.info.entities.resumes;

import com.netcracker.app.domain.info.entities.vacancies.VacancyImpl;
import com.netcracker.app.domain.users.entities.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Arrays;
import java.util.List;

@Entity
public class ResumeImpl extends AbstractResume {
    public ResumeImpl() {
        super();
    }

    public ResumeImpl(String firstName, String lastName, String birthday, String phone,
                      String email, String text, VacancyImpl vacancy) throws Exception {
        super(firstName, lastName, birthday, phone, email, text);
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static List<String> getFieldsNames() {
        String name = "firstName lastName birthday phone email text";
        List<String> names = Arrays.asList(name.split(" "));
        return names;
    }
    //Ctrl+Alt+I выравнивание
}
