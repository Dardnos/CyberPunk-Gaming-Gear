package no.ntnu.webshop.group12.webshop.models.product;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Set<Category> category = new LinkedHashSet<>();

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String image;

    @Positive
    private double price;

    @PositiveOrZero
    private int stock;

    public Product() {
    }

    public Product(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, String description, double price, int stock, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public void addCategory(Category category) {
        this.category.add(category);
    }

    public void removeCategory(Category category) {
        this.category.remove(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
