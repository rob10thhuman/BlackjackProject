package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	private List<Card> dealerHand;

	public Dealer() {
		dealerHand = new ArrayList<>();
	}
	
	public void add(Card dealCard) {
		dealerHand.add(dealCard);
	}

	public int dealerScore() {
		int dealerScore = 0;

		for (int i = 0; i < dealerHand.size(); i++) {
			dealerScore += dealerHand.get(i).getRank().getValue();
		}
		return dealerScore;
	}

	public List<Card> getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(List<Card> dealerHand) {
		this.dealerHand = dealerHand;
	}

	
}
