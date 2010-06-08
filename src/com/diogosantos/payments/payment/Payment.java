package com.diogosantos.payments.payment;

public abstract class Payment {

	public Double calculate(Double price) {
		return price = price - ((price / 100) * discount());
	}

	public abstract Integer discount();

}