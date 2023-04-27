package no.ntnu.webshop.group12.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import no.ntnu.webshop.group12.webshop.service.CartService;
import no.ntnu.webshop.group12.webshop.excpetion.NotFoundException;
import no.ntnu.webshop.group12.webshop.models.cart.Quantity;
import no.ntnu.webshop.group12.webshop.models.product.Product;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "Cart", description = "The cart API")
public class CartController {

    @Autowired
    private CartService cartService;

    @DeleteMapping("/product/{id}")
    public Product deleteProductFromCart(@PathVariable int id) throws NotFoundException {
        return cartService.removeProductFromCart(id);
    }

    @PatchMapping("/product/{id}/quantity/{quantity}")
    public Quantity updateProductQuantity(@PathVariable int id, @PathVariable int quantity) throws NotFoundException {
        return cartService.updateProductQuantity(id, quantity);
    }

}
