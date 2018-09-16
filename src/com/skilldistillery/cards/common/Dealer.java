package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	public static List<Card> dealerHand = new ArrayList<>();

	public static void add(Card dealCard) {
		dealerHand.add(dealCard);
	} 
	
	public static int dealerScore(){
		int dealerScore = 0; 
		
		for (int i = 0; i < dealerHand.size(); i++) {
		dealerScore += Dealer.dealerHand.get(i).getRank().getValue();  
	}
		return dealerScore; 
}
	
}


