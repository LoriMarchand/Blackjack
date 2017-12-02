package com.lmig.gfc.blackjack.models;

public class Game {

	private Deck deck = new Deck();
	private Hand player = new Hand();
	private Hand dealer = new Hand();
	private Purse purse = new Purse();
	private Bet currentBet;

	public Purse getPurse() {
		return purse;
	}

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

		Card card = deck.draw();
		player.accept(card);

		card = deck.draw();
		dealer.accept(card);

		card = deck.draw();
		player.accept(card);

		card = deck.draw();
		dealer.accept(card);

	}

	public boolean isplayerWinner() {
//		if (!playerIsBusted() && dealerIsBusted()) {
//			return true;
//		}
//		if (playerHasBlackjack() && !dealerHasBlackjack()) {
//			return true;
//		}
		if ((!playerIsBusted() && !dealerIsBusted()) && (player.getTotal() > dealer.getTotal())) {
			return true;
		}
		return false;

	}

	public boolean playerHasBlackjack() {
		if (player.numberOfCardsInHand() == 2 && player.getTotal() == 21) {
			return true;
		}
		return false;
	}

	public boolean dealerHasBlackjack() {
		if (dealer.numberOfCardsInHand() == 2 && dealer.getTotal() == 21) {
			return true;
		}
		return false;
	}

	public boolean playerHasTwentyOne() {
		if (player.numberOfCardsInHand() > 2 && player.getTotal() == 21) {
			return true;
		}
		return false;
	}

	public boolean dealerHasTwentyOne() {
		if (dealer.numberOfCardsInHand() > 2 && dealer.getTotal() == 21) {
			return true;
		}
		return false;
	}

	// if player busted is true
	public boolean playerIsBusted() {
		if (player.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public boolean dealerIsBusted() {
		if (dealer.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public boolean isTie() {
		if (player.getTotal() == dealer.getTotal()) {
			return true;
		}
		return false;
	}

	public boolean isHandOver() {
		if (player.getTotal() == 21) {
			return true;
		}

		return false;
	}

	// player busted
	public boolean playerHasMoreThan21() {
		if (player.getTotal() > 21) {
			return true;
		}
		return false;
	}

	// dealerbusted
	public boolean dealerHasMoreThan21() {
		if (dealer.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public boolean isGameOver() {
		if (player.getTotal() == dealer.getTotal()) {
			return true;
		}
		return false;
	}

	public void placeBet(int bet) {
		purse.minusBet(bet);
		currentBet = new Bet(bet);

	}
	
	public void makePayout() {
        if (playerHasBlackjack() && !dealerHasBlackjack()) {
            purse.blackJackPayout(currentBet.getAmount());
        } else if (isplayerWinner()) {
            purse.regularwinPayout(currentBet.getAmount());
        }
    }
	
	
}
