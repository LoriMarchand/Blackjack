package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck = new Deck();
	private Hand player = new Hand();
	private Hand dealer = new Hand();

	public void hitPlayer() {
		Card card = deck.draw();
		player.accept(card);
	}

	public void hitDealer() {

		while (dealer.getTotal() < 17) {
			Card card = deck.draw();
			dealer.accept(card);
		}

	}

	public Game() {
		deck.shuffle();
	}

	public void deal() {
		player = new Hand();
		dealer = new Hand();

		// Deal two cards to player and to dealer from the deck
		Card card = deck.draw();
		player.accept(card);

		card = deck.draw();
		dealer.accept(card);

		card = deck.draw();
		player.accept(card);

		card = deck.draw();
		dealer.accept(card);

	}
	

	public boolean playerHasMoreThan21() {
		if (player.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public boolean dealerHasMoreThan21() {
		if (dealer.getTotal() > 21) {
			return true;
		}
		return false;
	}

}
