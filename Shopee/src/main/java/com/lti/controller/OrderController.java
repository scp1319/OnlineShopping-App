package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Item;
import com.lti.entity.Order;
import com.lti.entity.Product;
import com.lti.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

    @GetMapping("/placeItemToOrder.lti")
    public void placeItemToOrder(@RequestParam("itemId") int itemId){
        orderService.placeItemToOrder(itemId);
    }

    @GetMapping("/getOrderList.lti")
    public List<Order> displayOrder(){
        return orderService.getOrderList();
    }

    @GetMapping("/getProductInOrder.lti")
    public Product getProductInOrder(@RequestParam("orderId") int orderId){
        return orderService.getProductInOrder(orderId);
    }


}