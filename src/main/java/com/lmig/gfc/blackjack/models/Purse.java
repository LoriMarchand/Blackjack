package com.lmig.gfc.blackjack.models;

public class Purse {

	private double money = 100;

	public void removeFromPurse(double bet) {

		money = money - bet;

	}

	public void addtoPurse(double bet) {

		money = money + bet;
	}

	public void blackJackPayout (int bet) {
        Double amountToAdd = bet * 2.5;
        money = money + amountToAdd.intValue();
    }
    
    public void regularwinPayout (int bet) {
        money = money + (bet * 2);
    }
	
	
	public boolean playerPurseIsEmpty() {
		if (money == 0) {
			return true;
		}
		return false;
	}

	public void minusBet(int bet) {
		money = money- bet;
	}
}
