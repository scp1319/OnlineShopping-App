package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.CartDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Cart;
import com.lti.entity.Item;
import com.lti.entity.Product;

@Service
public class CartService {
	@Autowired
	private GenericDao dao;
	@Autowired
	private CartDao cartDao;

	@Transactional
	public void addToCart(int cartId, int productId, int quantity) {
		Cart c = dao.fetchById(Cart.class, cartId);
		Product p = dao.fetchById(Product.class, productId);
		Item i = new Item();
		i.setCart(c);
		i.setProduct(p);
		i.setQuantity(quantity);
		dao.save(i);
		c.setTotal(c.getTotal() + p.getPrice() * i.getQuantity());
		dao.save(c);
	}

	public Cart displayCartService(int cartid) {
		return cartDao.displayCart(cartid);
	}

}
