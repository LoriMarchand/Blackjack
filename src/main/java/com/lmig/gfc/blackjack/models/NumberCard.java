package com.lmig.gfc.blackjack.models;

public class NumberCard extends Card {
	
	private int cardValue;
	
	public NumberCard(Suits suit, int value) {
		super(suit);
		this.cardValue = value;

	}
	
	@Override
	public String getFace() {
		
		return String.valueOf(cardValue);
	}

	@Override
	public int getValue() {
		return cardValue;
	}

}
