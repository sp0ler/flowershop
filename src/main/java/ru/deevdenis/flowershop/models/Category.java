package ru.deevdenis.flowershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;
    @Column(name = "name_image", length = 100)
    private String nameImage;
    @Column(name = "category_name_eng", nullable = false, unique = true)
    private String categoryNameEng;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Flower> categoryNameList = new ArrayList<>();
}
