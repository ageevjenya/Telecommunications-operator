package com.netcracker.app.domain.users.entities;

import com.netcracker.app.domain.info.entities.resumes.ResumeImpl;
import com.netcracker.app.domain.tariffs.entities.TariffHome;
import com.netcracker.app.domain.tariffs.entities.TariffMobile;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "Usr")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthday;
    private String number;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "tariffMobile_id")
    private TariffMobile tariffMobile;

    @ManyToOne
    @JoinColumn(name = "tariffHome_id")
    private TariffHome tariffHome;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "userUsedTariffMobile_id")
    private UserUsedTariffMobile userUsedTariffMobile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ResumeImpl> resumes;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    ;

    public User(String username,
                String password,
                String firstName,
                String middleName,
                String lastName,
                LocalDate birthday,
                String number,
                boolean active,
                Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.number = number;
        this.active = active;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public TariffMobile getTariffMobile() {
        return tariffMobile;
    }

    public void setTariffMobile(TariffMobile tariffMobile) {
        this.tariffMobile = tariffMobile;
    }

    public TariffHome getTariffHome() {
        return tariffHome;
    }

    public void setTariffHome(TariffHome tariffHome) {
        this.tariffHome = tariffHome;
    }

    public UserUsedTariffMobile getUserUsedTariffMobile() {
        return userUsedTariffMobile;
    }

    public void setUserUsedTariffMobile(UserUsedTariffMobile userUsedTariffMobile) {
        this.userUsedTariffMobile = userUsedTariffMobile;
    }

    public Set<ResumeImpl> getResume() {
        return resumes;
    }

    public void setResume(Set<ResumeImpl> resumes) {
        this.resumes = resumes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }
}
