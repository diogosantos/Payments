package com.diogosantos.payment;

import com.diogosantos.payments.order.Book;
import com.diogosantos.payments.order.Order;
import com.diogosantos.payments.payment.CashPayment;
import com.diogosantos.payments.payment.CreditCardPayment;
import com.diogosantos.payments.payment.DebitCardPayment;

import junit.framework.TestCase;

public class PaymentDiscountTester extends TestCase {
	
	Order order;
		
	public void setUp() {
		order = new Order();
		order.add( new Book(100.00) );
	}
	
	public void testShouldDiscountFivePercentOnDebitCardPayment() {				
		order.payment( new DebitCardPayment() );
		
		assertEquals( 95.00, order.totalPrice() );
	}
	
	public void testShouldDiscountTenPercentOnCashPayment() {				
		order.payment( new CashPayment() );
		
		assertEquals( 90.00, order.totalPrice() );		
	}
	
	public void testShouldNotDiscountOnCreditCardPayment() {				
		order.payment( new CreditCardPayment() );
		
		assertEquals( 100.00, order.totalPrice() );		
	}
	
}
