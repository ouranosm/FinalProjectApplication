package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.services;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entities.Cart;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entities.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entities.User;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void addProductToCart(User user, Product product) {
        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }
        cart.getProducts().add(product);
        cartRepository.save(cart);
    }

    public Cart getUserCart(User user) {
        return cartRepository.findById(user.getId()).orElseThrow();
    }

}
