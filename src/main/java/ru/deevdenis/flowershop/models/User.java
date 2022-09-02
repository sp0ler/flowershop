package ru.deevdenis.flowershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "email", unique = true, length = 100)
    private String email; // NOT NULL
    @Column(name = "login", unique = true, length = 100)
    private String login;
    @Column(name = "password", length = 100)
    private String password; // NOT NULL
    @Transient
    private String passwordConfirm;
    @Column(name = "phone_number", unique = true, length = 12)
    private String phoneNumber;
    @Column(name = "first_name", length = 30)
    private String firstName;
    @Column(name = "last_name", length = 30)
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "registration_date")
    private Date registrationDate; // NOT NULL
    @Column(name = "last_logon")
    private Date lastLogonDate; // NOT NULL
    @Column(name = "active")
    private boolean active; // NOT NULL

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @PrePersist
    private void init() {
        this.registrationDate = setDate();
        this.lastLogonDate = setDate();
    }

    public Date setDate() { return new Timestamp(System.currentTimeMillis());}

    public void updateLastLogonDate() { this.lastLogonDate = setDate(); }

    /*
     * SPRING SECURITY
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return active;
    }

}



