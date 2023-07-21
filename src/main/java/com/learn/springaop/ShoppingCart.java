package com.learn.springaop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	
	// cross cutting concerns (ASPECT) - logging, authentication & authorization, sanitizing the data etc.
	
	// joint point
	public void checkout(String status) {
		System.out.println("checkout method from shopping cart is called."); // business logic
	}
	
	public int quantity() {
		return 2;
	}

}
