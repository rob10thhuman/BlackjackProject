package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public static List<Card> playerHand = new ArrayList<>();

	public static void add(Card dealCard) {
		playerHand.add(dealCard);
	}

	public static int playerScore(){
		int playerScore = 0; 
		
		for (int i = 0; i < playerHand.size(); i++) {
		playerScore += Player.playerHand.get(i).getRank().getValue();  
	}
		return playerScore; 
}

}
