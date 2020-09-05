package com.netcracker.app.domain.users.entities;

import com.netcracker.app.domain.tariffs.entities.TariffMobile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
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
    private Integer age;
    private String number;
    private boolean active;

    @ManyToOne
    @JoinColumn(name="tariffMobile_id")
    private TariffMobile tariffMobile;

    @ManyToOne
    @JoinColumn(name="tariffHome_id")
    private TariffMobile tariffHome;

    @OneToOne
    @JoinColumn(name="userUsedTariff_id")
    private UserUsedTariff userUsedTariff;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public TariffMobile getMobileTariff() {
        return tariffMobile;
    }

    public void setMobileTariff(TariffMobile tariffMobile) {
        this.tariffMobile = tariffMobile;
    }

    public TariffMobile getTariffHome() {
        return tariffHome;
    }

    public void setTariffHome(TariffMobile tariffHome) {
        this.tariffHome = tariffHome;
    }

    public UserUsedTariff getUserUsedTariff() {
        return userUsedTariff;
    }

    public void setUserUsedTariff(UserUsedTariff userUsedTariff) {
        this.userUsedTariff = userUsedTariff;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin(){
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
