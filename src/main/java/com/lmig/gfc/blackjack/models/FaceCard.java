package com.lmig.gfc.blackjack.models;

public class FaceCard extends Card {
	private Faces face;

	public FaceCard(Suits suit, Faces face) {
		super(suit);
		this.face = face;
	}

	@Override
	public String getFace() {

		return face.toString();

	}

	@Override
	public int getValue() {

		return 10;
	}
}
