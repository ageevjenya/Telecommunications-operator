package com.netcracker.app.domain.info.entities.networkcoveragemap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;


@JsonDeserialize(using = TypePointAccesDeserializer.class)
public enum TypePointAcces implements GrantedAuthority {

    G2("2G"),

    G3("3G"),

    G4("4G");

    private String title;


    TypePointAcces(String title) {
        this.title = title;
    }


    public void setTitle(String title) {
        this.title = title;
    }



    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthority() {
        return name();
    }

    @Override
    public String toString() {
        return title;}

//    @JsonCreator
    public static TypePointAcces fromTitle(String title){
        for(TypePointAcces t : TypePointAcces.values()){
            if (t.getTitle().equals(title)){
                return t;
            }
        }
        return TypePointAcces.G2;
    }

}
