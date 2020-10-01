package com.netcracker.app.domain.users.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, MANAGER, SUPPORT, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

}
