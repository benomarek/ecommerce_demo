package com.garwan.ecommece.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animal_category")
@Getter
@Setter
@NoArgsConstructor
public class AnimalCategory {

    public AnimalCategory(String name) {
        this.name = name;
    }

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalCategory")
    private Set<Product> products;
}
