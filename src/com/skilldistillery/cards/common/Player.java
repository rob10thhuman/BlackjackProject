package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> playerHand;

	public Player() {
		playerHand = new ArrayList<>(); 
	}
	

	public void add(Card dealCard) {
		playerHand.add(dealCard);
	}

	public int playerScore() {
		int playerScore = 0;

		for (int i = 0; i < playerHand.size(); i++) {
			playerScore += playerHand.get(i).getRank().getValue();
		}
		return playerScore;
	}

	public List<Card> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(List<Card> playerHand) {
		this.playerHand = playerHand;
	}

}
