package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

	private ArrayList<Card> cardDeck;
	
	// declare a private variable that holds a collection of cards

	public Deck() {
		cardDeck = new ArrayList<Card>();
		
		for (Suits suit : Suits.values()) {
			AceCard aceCard;
			aceCard = new AceCard(suit);
			cardDeck.add(aceCard);
			
			for (Faces faces : Faces.values()) {
				FaceCard faceCard;
				faceCard = new FaceCard(suit, faces);
				cardDeck.add(faceCard);				
			}
			for (int i =2; i <=10; i = i + 1) {
				NumberCard numberCard;
				numberCard =  new NumberCard(suit, i);
				cardDeck.add(numberCard);
			}
						
		}
	}
	
	public ArrayList<Card> getCardDeck(){
		return cardDeck;
		
	}
	public int size() {
		return cardDeck.size();
	}

	public Card draw() {
		Card card = cardDeck.remove(0);
		return card;
	}

	public void shuffle() {
	Collections.shuffle(cardDeck);
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
