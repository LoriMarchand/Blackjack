package com.lmig.gfc.blackjack.models;


import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private ArrayList<Card> cards;
	
	public Hand() {
	
		cards = new  ArrayList<Card>();
		
	}

	public void accept(Card card) {
		cards.add(card);
		
	}
	
	public List<Card> getCards(){
		return cards;
	}
	
	public int getTotal() {
		int sum = 0;
		for (Card card :cards) {
			sum += card.getValue();
		}
		return sum; 
	}

}
