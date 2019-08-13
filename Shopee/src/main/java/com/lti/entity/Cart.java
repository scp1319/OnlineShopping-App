package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CART")
public class Cart {
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Id
	@Column(name="cart_id")
	private int cartId;
	private double total;
	
	@OneToOne(mappedBy="cart",cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
	private Set<Item> items;
	
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	}
