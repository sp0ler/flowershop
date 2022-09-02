package ru.deevdenis.flowershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "cookie")
    private String cookie;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;

}
