package com.netcracker.app.info.entities.vacancies;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractVacancy implements Vacancy {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String text;

    public AbstractVacancy(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public AbstractVacancy() {}

    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
