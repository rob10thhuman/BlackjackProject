package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	public static List<Card> dealerHand = new ArrayList<>();

	public static void add(Card dealCard) {
		dealerHand.add(dealCard);
	} 
	
}


