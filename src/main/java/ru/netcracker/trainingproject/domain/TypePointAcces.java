package ru.netcracker.trainingproject.domain;

import org.springframework.security.core.GrantedAuthority;

public enum TypePointAcces implements GrantedAuthority {
    G2("2G"),
    G3("3G"),
    G4("4G");

    private String title;

    TypePointAcces(String title) {
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
