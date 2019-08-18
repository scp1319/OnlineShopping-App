package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CartValue;
import com.lti.entity.Cart;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/addToCart.lti")
	public void addProductToCart(@RequestBody CartValue cartValues) {
		cartService.addToCart(cartValues.getCartId(), cartValues.getProductId(), cartValues.getQuantity());
	}

	@GetMapping("/displayCart.lti")
	public List<Item> displayProductsInCart(@RequestParam("cartId") int cartid) {
		return cartService.displayCartService(cartid);
	}
	
	@GetMapping("/displayCartItemName.lti")
	public Product displayCartItemName(@RequestParam("itemId") int itemId) {
		return cartService.displayCartItemName(itemId);
	}
	
	
	
	@DeleteMapping("/deleteFromCart.lti")
	public void deleteFromCart(@RequestParam("itemId") int itemId) {
		cartService.removeItemFromCart(itemId);
	}
	
	@GetMapping("/fetchCartByUserId.lti")
	public Cart fetchCartByUserId(@RequestParam("userId") int userId) {
		return cartService.fetchCartByUserId(userId);
	}
	
}
