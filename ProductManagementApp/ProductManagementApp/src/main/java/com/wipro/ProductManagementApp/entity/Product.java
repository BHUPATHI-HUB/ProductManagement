package com.wipro.ProductManagementApp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity

public class Product {

    @Id
    private int id;
    private String name;
    private String price;
    private String quantity;

    public Product(String name, String price, String quantity, int id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = (int) id;
    }

    public Product() {
        this.name = "product not found";
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public int getId() { return id; }
    public void setId(int id) { this.id = (int) id; }
}
