package de.commercetools;

import java.math.BigDecimal;
import java.util.Currency;

public final class Money {

	private BigDecimal amountValue;
	private Currency currency;
	
	
	private Money(BigDecimal amount, Currency currency) {
		this.amountValue = amount;
		this.currency = currency;
	}

	public Money(String amountValue, String currencyCode) {
		this(new BigDecimal(amountValue), Currency.getInstance(currencyCode));
	}


	public Money multiplyBy(int factor) {
		return new Money(this.amountValue.multiply(new BigDecimal(factor)), getCurrency());
	}

	public Currency getCurrency() {
		return currency;
	}

	public BigDecimal getAmountValue() {
		return amountValue;
	}

	@Override
	public String toString() {
		return getAmountValue() + " " + getCurrency().getSymbol();
	}

	public static void main(String[] args) {
		final Money EUR = new Money("67.89", "EUR");
		final Money USD = new Money("98.76", "USD");

		System.out.println(EUR);
		System.out.println(USD);
		System.out.println(EUR.multiplyBy(6));
		System.out.println(USD.multiplyBy(6));
	}
}
