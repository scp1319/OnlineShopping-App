package com.lti.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.CartDao;
import com.lti.dao.GenericDao;
import com.lti.dao.OrderDao;
import com.lti.entity.Cart;
import com.lti.entity.Item;
import com.lti.entity.Order;
import com.lti.entity.Product;

@Service
public class OrderService{
	
    @Autowired
	private GenericDao dao;
    
    @Autowired
   	private OrderDao orderDao;

    @Transactional
    public void placeItemToOrder(int itemId){
        Item item =dao.fetchById(Item.class, itemId);
        Product product = item.getProduct();
        Cart cart=dao.fetchById(Cart.class, item.getCart().getCartId());
        //order remaing
        Order order = new Order();
        order.setProduct(product);
        order.setStatus("In Transit");
        order.setPaymentMode("COD");
        order.setDateAndTime(LocalDateTime.now());
        product.setStock(product.getStock() - 1);
        cart.setTotal(cart.getTotal()-item.getProduct().getPrice()*item.getQuantity());
        dao.save(order);
        dao.delete(item);   
    }


    @Transactional
    public List<Order> getOrderList(int userId){
        return orderDao.getOrderList(userId);
    }

    @Transactional
    public Product getProductInOrder(int orderId){
        Order order = dao.fetchById(Order.class, orderId);
        Product product = dao.fetchById(Product.class, order.getProduct().getId());
        return product;
    }
}