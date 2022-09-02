package ru.deevdenis.flowershop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flowers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title", length = 100)
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "category_name", length = 100)
    private String categoryName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "flower")
    private List<Cart> cartList = new ArrayList<>();;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinTable(
//            name = "cart_flowers",
//            joinColumns = { @JoinColumn(name = "cart_id") },
//            inverseJoinColumns = { @JoinColumn(name = "flowers_id") }
//    )
//    private List<Cart> cartList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flower")
    private List<FlowerImages> flowerImagesList = new ArrayList<>();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryName='" + categoryName + '\'' +
                ", category=" + category +
                ", cartList=" + cartList +
                ", flowerImagesList=" + flowerImagesList +
                '}';
    }
}
