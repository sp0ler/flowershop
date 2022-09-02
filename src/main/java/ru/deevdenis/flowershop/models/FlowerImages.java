package ru.deevdenis.flowershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "flowers_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowerImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name_image", length = 100)
    private String nameImage;
    @Column(name = "preview")
    private boolean preview = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flower_id")
    private Flower flower;
}
