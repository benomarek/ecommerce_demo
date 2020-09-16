package com.garwan.ecommece.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gallery_url")
@Getter
@Setter
@NoArgsConstructor
public class GalleryUrl {

    public GalleryUrl(Long id, String url) {
        this.id = id;
        this.url = url;
    }
    public GalleryUrl(Long id, String url, Product product) {
        this.id = id;
        this.url = url;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
