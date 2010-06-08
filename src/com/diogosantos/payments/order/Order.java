package com.diogosantos.payments.order;

import java.util.ArrayList;
import java.util.List;

import com.diogosantos.payments.payment.Payment;

public class Order {

	List<Book> products = new ArrayList<Book>();
	
	private Payment payment;
	
	public void add(Book book) {
		products.add(book);
	}

	public void payment(Payment cardPayment) {
		this.payment = cardPayment;
	}

	public Double totalPrice() {		
		return payment.calculate( producstPrice() );
	}

	private Double producstPrice() {
		Double price = new Double(0);
		for(Book book : products) {
			price = book.price() + price;
		}
		return price;
	}

}
