package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.skilldistillery.cards.common.*;

public class Hand {
	public List<Card> hand = new ArrayList<>();
	
	public Hand() {
		
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void add(Card card) {
		card.add(card);
		
	}

	
	
	
	
	
	//	private Suit suit; 
//	private Rank rank;
//	
//	public Suit getSuit() {
//		return suit;
//	}
//	public void setSuit(Suit suit) {
//		this.suit = suit;
//	}
//	public Rank getRank() {
//		return rank;
//	}
//	public void setRank(Rank rank) {
//		this.rank = rank;
//	} 


	
}

