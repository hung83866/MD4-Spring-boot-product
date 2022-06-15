package com.codegym.testproduct.model;

import javax.persistence.*;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String img;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    public Product(Long id, String name, double price, String img, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
