package ru.deevdenis.flowershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_role")
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {}

    public Role(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    @Override
    public String getAuthority() {
        return getName();
    }
}

