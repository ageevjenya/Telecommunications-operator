package ru.netcracker.trainingproject.domain;

import org.springframework.security.core.GrantedAuthority;

public enum TypePointAcces implements GrantedAuthority {
    G2("2G"),
    G3("3G"),
    G4("4G");

    private String title;

//    public boolean isState() {
//        return state;
//    }
//
//    public void setState(boolean state) {
//        this.state = state;
//    }
//
//    private boolean state;

    public void setTitle(String title) {
        this.title = title;
    }

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
