package no.ntnu.webshop.group12.webshop.models.purchase;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import no.ntnu.webshop.group12.webshop.models.User;
import no.ntnu.webshop.group12.webshop.models.cart.Cart;

@Entity
public class Purchase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "DATE", name = "date", updatable = false)
    LocalDate date;

    @OneToMany
    @Column(updatable = false)
    Set<Item> products;

    @ManyToOne
    @JoinColumn(updatable = false, name = "user_id")
    User user;

    public Purchase() {
    }

    public Purchase(Cart cart) {
        date = LocalDate.now();
        products = new HashSet<>();
        user = cart.getUser();
        cart.getProducts().forEach(quantity -> {
            addItem(new Item(quantity));
        });
    }

    public void addItem(Item item) {
        products.add(item);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Item> getProducts() {
        return products;
    }

    public void setProducts(Set<Item> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
