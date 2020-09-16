package com.garwan.ecommece.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor

public class Product {

    public Product(Long id, String name, BigDecimal price, String description, List<GalleryUrl> gallery, AnimalCategory animalCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.gallery = gallery;
        this.animalCategory = animalCategory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER)
    private List<GalleryUrl> gallery;

    @ManyToOne
    @JoinColumn(name = "animal_category", nullable = false)
    private AnimalCategory animalCategory;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders;
}
